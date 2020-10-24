package br.com.zup.mayconkevin.nossobanco.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.zup.mayconkevin.nossobanco.domain.Address;
import br.com.zup.mayconkevin.nossobanco.domain.City;
import br.com.zup.mayconkevin.nossobanco.domain.Client;
import br.com.zup.mayconkevin.nossobanco.domain.Proposal;
import br.com.zup.mayconkevin.nossobanco.domain.State;
import br.com.zup.mayconkevin.nossobanco.domain.enums.StatusProposal;
import br.com.zup.mayconkevin.nossobanco.domain.enums.StepProposal;
import br.com.zup.mayconkevin.nossobanco.dto.ClientDTO;
import br.com.zup.mayconkevin.nossobanco.dto.ClientNewDTO;
import br.com.zup.mayconkevin.nossobanco.repositories.AddressRepository;
import br.com.zup.mayconkevin.nossobanco.repositories.CityRepository;
import br.com.zup.mayconkevin.nossobanco.repositories.ClientRepository;
import br.com.zup.mayconkevin.nossobanco.repositories.ProposalRepository;
import br.com.zup.mayconkevin.nossobanco.repositories.StateRepository;
import br.com.zup.mayconkevin.nossobanco.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repo;
	@Autowired
	private ProposalRepository propRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	
	public Client insert(Client obj) {
		obj.setId(null);
		obj = repo.save(obj);
		propRepo.save(new Proposal(null,
							new Date( System.currentTimeMillis() ),
							StepProposal.BASIC,
							null,
							obj,
							null));
		return obj;
	}
	public Client fromDTO(ClientDTO objDTO) {
		return new Client(objDTO.getId(), objDTO.getName(), objDTO.getLastName(), objDTO.getEmail(), null, null);
	}
	public Client fromDTO(ClientNewDTO objDTO) {
		Client client = new Client(null, objDTO.getName(), objDTO.getLastName(),
				objDTO.getEmail(), objDTO.getBirthday(), objDTO.getCpf());
		/*
		State state = new State(null, objDTO.getStateName());
		
		City city = new City(null, objDTO.getCityName(), state);
		
		Address address = new Address(null, objDTO.getCep(), objDTO.getStreet(),
				objDTO.getNeighborhood(), objDTO.getComplement(), client, city);
		client.getAddresses().add(address);
		
		Proposal proposal = new Proposal(null, new Date( System.currentTimeMillis() ), StepProposal.ADDRESS,
				StatusProposal.toEnum( objDTO.getStatus() ), client);
		*/
		return client;
	}
	
	
	public Client find(Integer id) {
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException(
										"Object not found! ID: " + id +
										", Type: " + Client.class.getName() )
							);
	}
	public List<Client> findAll() {
		return repo.findAll();
	}
	public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		throw new UnsupportedOperationException();
	}

	
	public Client update(Client obj) {
		Client oldObj = find(obj.getId());
		updateData(oldObj, obj);
		return repo.save(oldObj);
	}
	private void updateData(Client oldObj, Client obj) {
		oldObj.setName(obj.getName());
		oldObj.setLastName(obj.getLastName());
		oldObj.setEmail(obj.getEmail());
	}

	
	public void delete(Integer id) {
		repo.deleteById(id);
		/*try { repo.deleteById(id); }
		catch (DataIntegrityViolationException err) {
			throw new DataIntegrityViolationException("Can't delete because there are related entities");
			System.out.println(err.toString());
		}*/
	}
}
