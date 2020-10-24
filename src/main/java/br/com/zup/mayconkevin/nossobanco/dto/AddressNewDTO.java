package br.com.zup.mayconkevin.nossobanco.dto;

import java.io.Serializable;

public class AddressNewDTO  implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer cep;
	private String street;
	private	String neighborhood;
	private String complement;
	
	private String cityName;
	private String stateName;

	private Integer clientID;
	
	public AddressNewDTO() {}
	
	public Integer getCEP() {
		return cep;
	}

	public void setCEP(Integer cep) {
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

	public Integer getClientID() {
		return clientID;
	}

	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}
}
