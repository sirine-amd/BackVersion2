package com.pfe.back.BackPfe.responses;

public class ResponsePassword {
	private Long id;
	private String password;
	

	
	public ResponsePassword() {
		super();
	}

	public ResponsePassword(Long id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
