package id.co.telkomsigma.tmf.data.dto.response;

import id.co.telkomsigma.tmf.data.dto.ResponseData;

import java.io.Serializable;

public class RegistrationMemberResponseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4214854974739264314L;

	private String token;
	private ResponseData responseData;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public ResponseData getResponseData() {
		return responseData;
	}
	public void setResponseData(ResponseData responseData) {
		this.responseData = responseData;
	}
	@Override
	public String toString() {
		return "RegistrationMemberResponseDTO [token=" + token + ", responseData=" + responseData + "]";
	}
	
	
}
