package id.co.telkomsigma.tmf.data.dto.request;

import java.io.Serializable;

public class RequestMemberActivationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3625783656199546156L;
	
	private String email;
	private String token;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "RequestMemberActivationDTO [email=" + email + ", token=" + token + "]";
	}
	
	
}
