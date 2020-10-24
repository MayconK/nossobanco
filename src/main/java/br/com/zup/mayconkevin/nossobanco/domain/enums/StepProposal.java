package br.com.zup.mayconkevin.nossobanco.domain.enums;

public enum StepProposal {
	
	BASIC (1, "Basic registration information of new Client"),
	ADDRESS (2, "Address of new Client"),
	PHOTO (3, "In development"),
	CONFIRMATION (4, "Confirmation data");
	
	private int id;
	private String description;
	
	private StepProposal(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public static StepProposal toEnum(Integer id) {
		if(id == null) return null;
		
		for (StepProposal s : StepProposal.values()) {
			if( id.equals(s.getId()) )
				return s;
		}
		
		throw new IllegalArgumentException("Invalid ID: " + id);
	}
}
