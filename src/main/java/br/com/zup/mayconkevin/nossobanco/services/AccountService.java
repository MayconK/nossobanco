package br.com.zup.mayconkevin.nossobanco.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.mayconkevin.nossobanco.domain.Account;
import br.com.zup.mayconkevin.nossobanco.repositories.AccountRepository;
import br.com.zup.mayconkevin.nossobanco.repositories.ProposalRepository;
import br.com.zup.mayconkevin.nossobanco.services.exceptions.ObjectNotFoundException;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repo;
	@Autowired
	private ProposalRepository proposalRepo;
	
	@Transactional
	public Account insert(Account obj) {
		obj.setId(null);
		obj.setBank(341);
		obj.setAg("0001");
		obj.setCc("1234567-8");
		obj.setBalance(0.0);
		
		return repo.save(obj);
		
	}

	
	public Account find(Integer id) {
		Optional<Account> obj = repo.findById(id);
		return obj.orElseThrow( () -> new ObjectNotFoundException(
										"Object not found! ID: " + id +
										", Type: " + Account.class.getName() )
							);
	}
}
