package br.com.zup.mayconkevin.nossobanco.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.mayconkevin.nossobanco.domain.Account;
import br.com.zup.mayconkevin.nossobanco.domain.Address;
import br.com.zup.mayconkevin.nossobanco.domain.Client;
import br.com.zup.mayconkevin.nossobanco.domain.Proposal;
import br.com.zup.mayconkevin.nossobanco.domain.enums.StatusProposal;
import br.com.zup.mayconkevin.nossobanco.domain.enums.StepProposal;
import br.com.zup.mayconkevin.nossobanco.dto.AddressNewDTO;
import br.com.zup.mayconkevin.nossobanco.dto.ClientNewDTO;
import br.com.zup.mayconkevin.nossobanco.dto.ProposalDTO;
import br.com.zup.mayconkevin.nossobanco.services.AccountService;
import br.com.zup.mayconkevin.nossobanco.services.AddressService;
import br.com.zup.mayconkevin.nossobanco.services.ClientService;
import br.com.zup.mayconkevin.nossobanco.services.ProposalService;

@RestController
@RequestMapping(value = "/register")
public class RegisterResource {
	
	@Autowired
	private ClientService clientService;

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private ProposalService proposalService;
	
	@Autowired
	private AccountService accountService;
	
	 //
	// PRIMEIRA ETAPA
	@RequestMapping(value = "/step1", method = RequestMethod.POST)
	public ResponseEntity<Void> insertClient(@Valid @RequestBody ClientNewDTO objDTO) {
		Client obj = clientService.fromDTO(objDTO);
		obj = clientService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.replacePath("register/step2/").build().toUri();
		return ResponseEntity.created(uri).build();
	}
	
	 //
	// SEGUNDA ETAPA
	@RequestMapping(value="/step2", method = RequestMethod.POST)
	public ResponseEntity<Void> insertAddress(@RequestHeader(value="CPF") String CPF,
										@Valid @RequestBody AddressNewDTO objDTO ) {
		Address obj = addressService.fromDTO(objDTO);
		obj = addressService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.replacePath("register/step3/").build().toUri();
		return ResponseEntity.created(uri).build();
	}

	 //
	// QUARTA ETAPA
	@RequestMapping(value="/step4/{idProposal}", method = RequestMethod.GET)
	public ResponseEntity<ProposalDTO> returnProposal(@PathVariable Integer idProposal) {
		
		Proposal prop = proposalService.find(idProposal);
		prop.setStep(StepProposal.CONFIRMATION);
		prop.setStatus(StatusProposal.AWAITING);
		proposalService.update(prop);
		
		return ResponseEntity.ok( proposalService.toDTO(idProposal) );
	}

	 //
	// QUINTA ETAPA
	@RequestMapping(value="/step5/{idProposal}", method = RequestMethod.GET)
	public ResponseEntity<Account> createAccount(@PathVariable Integer idProposal) {
		Proposal prop = proposalService.find(idProposal);
		Account acc = new Account();
		acc.setClient(prop.getClient());
		acc = accountService.insert(acc);
		prop.setAccount( acc );
		prop.setStatus(StatusProposal.ACCEPTED);
		proposalService.update(prop);
		
		return ResponseEntity.ok( acc );
	}
}
