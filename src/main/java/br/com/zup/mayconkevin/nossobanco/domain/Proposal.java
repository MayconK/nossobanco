package br.com.zup.mayconkevin.nossobanco.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import br.com.zup.mayconkevin.nossobanco.domain.enums.StatusProposal;
import br.com.zup.mayconkevin.nossobanco.domain.enums.StepProposal;

@Entity
public class Proposal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date date;
	private Integer step;
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	@OneToOne
	@JoinColumn(name="account_id")
	private Account account;

	public Proposal() {}
	public Proposal(Integer id, Date date, StepProposal step, StatusProposal status, Client client, Account account) {
		super();
		this.id = id;
		this.date = date;
		this.step = step.getId();
		this.status = (status==null) ? null : status.getId();
		this.client = client;
		this.account = account;
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

	public StepProposal getStep() {
		return StepProposal.toEnum(step);
	}

	public void setStep(StepProposal step) {
		this.step = step.getId();
	}

	public StatusProposal getStatus() {
		return StatusProposal.toEnum(status);
	}

	public void setStatus(StatusProposal status) {
		this.status = status.getId();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proposal other = (Proposal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
