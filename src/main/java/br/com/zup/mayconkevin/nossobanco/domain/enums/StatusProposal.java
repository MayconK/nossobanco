package br.com.zup.mayconkevin.nossobanco.domain.enums;

public enum StatusProposal {

	RECUSED_BY_CLIENT(0, "Client recused proposal"),
	AWAITING(1, "Awaiting analysis"),
	DENIED(2, "Proposal denied"),
	ACCEPTED(3, "Proposal approved");
	
	private int id;
	private String description;
	
	private StatusProposal(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public static StatusProposal toEnum(Integer id) {
		if(id == null) return null;
		
		for (StatusProposal s : StatusProposal.values()) {
			if( id.equals(s.getId()) )
				return s;
		}
		
		throw new IllegalArgumentException("Invalid ID: " + id);
	}
}
