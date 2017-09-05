package id.co.telkomsigma.tmf.data.dto.request;

import java.io.Serializable;

public class RequestResetPasswordDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1710247954189366141L;
	
	private String token;
	private String newPassword;
	private String retypeNewPassword;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getRetypeNewPassword() {
		return retypeNewPassword;
	}
	public void setRetypeNewPassword(String retypeNewPassword) {
		this.retypeNewPassword = retypeNewPassword;
	}
	@Override
	public String toString() {
		return "RequestResetPasswordDTO [token=" + token + ", newPassword=" + newPassword + ", retypeNewPassword="
				+ retypeNewPassword + "]";
	}
	
	

}
