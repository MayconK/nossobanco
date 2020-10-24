package br.com.zup.mayconkevin.nossobanco.dto;

import java.io.Serializable;
import java.util.Date;

public class ClientNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer status;
	
	private String name;
	private String lastName;
	private String email;
	private Date birthday;
	private String cpf;
	
	public ClientNewDTO() {}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	
}
