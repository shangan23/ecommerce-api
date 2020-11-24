package io.shangan23.api.model;

public class Authentication {

	private String usertName;
	private String password;
	private String jwt;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	public Authentication(String jwt) {
		super();
		this.jwt = jwt;
	}

	public Authentication(String usertName, String password) {
		super();
		this.usertName = usertName;
		this.password = password;
	}

	public String getUsertName() {
		return usertName;
	}

	public void setUsertName(String usertName) {
		this.usertName = usertName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
