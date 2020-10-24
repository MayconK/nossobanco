package br.com.zup.mayconkevin.nossobanco.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.zup.mayconkevin.nossobanco.domain.Address;
import br.com.zup.mayconkevin.nossobanco.domain.Client;

public class ProposalDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date date;
	
	private String name;
	private String lastName;
	private String email;
	private Date birthday;
	private String cpf;
	
	private Integer cep;
	private String street;
	private	String neighborhood;
	private String complement;
	
	private String cityName;
	private String stateName;
	
	public ProposalDTO() {}


	public void setClient(Client client) {
		this.name = client.getName();
		this.lastName = client.getLastName();
		this.email = client.getEmail();
		this.birthday = client.getBirthday();
		this.cpf = client.getCPF();
	}
	
	public void setAddress(Address address) {
		this.cep = address.getCEP();
		this.street = address.getStreet();
		this.neighborhood = address.getNeighborhood();
		this.complement = address.getComplement();
		
		this.cityName = address.getCity().getName();
		this.stateName = address.getCity().getState().getName();
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	
	
}
