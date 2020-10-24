package br.com.zup.mayconkevin.nossobanco.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import br.com.zup.mayconkevin.nossobanco.domain.Client;

public class ClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Name cannot be null")
	private String name;
	
	@NotEmpty(message = "Last Name cannot be null")
	private String lastName;
	
	@NotEmpty(message = "E-mail cannot be null")
	@Email(message = "E-mail should be valid")
	private String email;
	
	@Min(value = 18, message = "Age should not be less than 18")
	private Integer age;
	
	public ClientDTO() {}
	public ClientDTO(Client obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.lastName = obj.getLastName();
		this.email = obj.getEmail();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	
}
