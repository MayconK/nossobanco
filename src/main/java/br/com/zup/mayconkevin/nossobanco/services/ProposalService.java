package br.com.zup.mayconkevin.nossobanco.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.zup.mayconkevin.nossobanco.domain.Account;
import br.com.zup.mayconkevin.nossobanco.domain.Address;
import br.com.zup.mayconkevin.nossobanco.domain.City;
import br.com.zup.mayconkevin.nossobanco.domain.Client;
import br.com.zup.mayconkevin.nossobanco.domain.Proposal;
import br.com.zup.mayconkevin.nossobanco.dto.ProposalDTO;
import br.com.zup.mayconkevin.nossobanco.dto.ProposalNewDTO;
import br.com.zup.mayconkevin.nossobanco.repositories.AccountRepository;
import br.com.zup.mayconkevin.nossobanco.repositories.ClientRepository;
import br.com.zup.mayconkevin.nossobanco.repositories.ProposalRepository;
import br.com.zup.mayconkevin.nossobanco.services.exceptions.ObjectNotFoundException;

@Service
public class ProposalService {
	
	@Autowired
	private ProposalRepository repo;
	@Autowired
	private AccountRepository accountRepo;
	
	@Transactional
	public Proposal insert(Proposal obj) {
		obj.setId(null);
		obj.setDate( new Date(System.currentTimeMillis()) );
		//clientRepo.save(obj.getClient());
		return repo.save(obj);
		
	}

//	public Proposal fromDTO(ProposalDTO objDTO) {
//		return new Client(objDTO.getId(), objDTO.getName(), objDTO.getLastName(), objDTO.getEmail(), null, null);
//		
//	}

	public ProposalDTO toDTO(Integer id) {
		Proposal proposal = find(id);
		
		ProposalDTO proposalDTO = new ProposalDTO();
		proposalDTO.setId(proposal.getId());
		proposalDTO.setDate(proposal.getDate());
		
		proposalDTO.setClient(proposal.getClient());
		proposalDTO.setAddress(proposal.getClient().getAddresses().get(0));
		
		return proposalDTO;
	}
	
	public Proposal find(Integer id) {
		Optional<Proposal> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException(
										"Object not found! ID: " + id +
										", Type: " + Proposal.class.getName() )
							);
	}

	public List<Proposal> findAll() {
		return repo.findAll();
	}

	public Page<Proposal> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		throw new UnsupportedOperationException();
	}
	
	public Proposal update(Proposal obj) {
		return repo.save(obj);
	}
/*
	private void updateData(Proposal oldObj, Proposal obj) {
		
		oldObj.setStatus(obj.getStatus());
	}*/
}
