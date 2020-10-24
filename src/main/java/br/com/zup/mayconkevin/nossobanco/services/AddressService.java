package br.com.zup.mayconkevin.nossobanco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.zup.mayconkevin.nossobanco.domain.Address;
import br.com.zup.mayconkevin.nossobanco.domain.City;
import br.com.zup.mayconkevin.nossobanco.domain.Client;
import br.com.zup.mayconkevin.nossobanco.domain.State;
import br.com.zup.mayconkevin.nossobanco.dto.AddressNewDTO;
import br.com.zup.mayconkevin.nossobanco.repositories.AddressRepository;
import br.com.zup.mayconkevin.nossobanco.repositories.CityRepository;
import br.com.zup.mayconkevin.nossobanco.repositories.StateRepository;
import br.com.zup.mayconkevin.nossobanco.services.exceptions.ObjectNotFoundException;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	
	public Address insert(Address obj) {
		obj.setId(null);
		stateRepo.save(obj.getCity().getState());
		cityRepo.save(obj.getCity());
		obj = repo.save(obj);
		return obj;
	}
	public Address fromDTO(AddressNewDTO objDTO) {
		Client client = new Client( objDTO.getClientID(), null, null, null, null, null);
		State state = new State(null, objDTO.getStateName());
		City city = new City(null, objDTO.getCityName(), state);
		
		return new Address(null, objDTO.getCEP(), objDTO.getStreet(),
				objDTO.getNeighborhood(), objDTO.getComplement(), client, city);
	}
	
	
	public Address find(Integer id) {
		Optional<Address> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException(
										"Object not found! ID: " + id +
										", Type: " + Address.class.getName() )
							);
	}
	public List<Address> findAll() {
		return repo.findAll();
	}
	public Page<Address> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		throw new UnsupportedOperationException();
	}

	
	public Address update(Address obj) {
		return repo.save(obj);
	}

	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
