package br.com.zup.mayconkevin.nossobanco.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transfer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double value;
	private String type;
	private Integer bank;
	private String ag;
	private String cc;
	private Boolean executed;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	private Transfer() {}
}
