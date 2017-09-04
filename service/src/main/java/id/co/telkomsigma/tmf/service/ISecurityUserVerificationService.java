package id.co.telkomsigma.tmf.service;

import id.co.telkomsigma.tmf.data.model.security.SecurityUserVerification;
import id.co.telkomsigma.tmf.data.model.security.User;

public interface ISecurityUserVerificationService {

	String insert(SecurityUserVerification p_SecurityUserVerification);
	
	String generateTokenVerification();
	
	boolean verifyToken(String p_Token);
	
	User findUserByToken(String p_Token);
}
