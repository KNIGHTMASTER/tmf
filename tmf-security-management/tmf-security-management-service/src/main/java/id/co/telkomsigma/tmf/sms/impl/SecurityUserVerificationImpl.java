package id.co.telkomsigma.tmf.sms.impl;

import id.co.telkomsigma.tmf.dao.ISecurityUserVerificationDAO;
import id.co.telkomsigma.tmf.data.model.security.SecurityUserVerification;
import id.co.telkomsigma.tmf.data.model.security.User;
import id.co.telkomsigma.tmf.sms.ISecurityUserVerificationService;
import id.co.telkomsigma.tmf.util.common.random.RandomStringGenerator;
import id.co.telkomsigma.tmf.util.common.time.TimeCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SecurityUserVerificationImpl implements ISecurityUserVerificationService {

	@Autowired
	ISecurityUserVerificationDAO securityUserVerificationDAO;
	
	private static final int TOKEN_LENGTH = 50;
	private static final int DEFAULT_EXPIRY_DATE = 1440;//in minutes 
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUserVerificationImpl.class);
	
	@Override
	public String insert(SecurityUserVerification p_SecurityUserVerification) {
		String token = generateTokenVerification();
		p_SecurityUserVerification.setExpiryDate(TimeCalculator.addMinutesToDate(DEFAULT_EXPIRY_DATE, new Date()));
		p_SecurityUserVerification.setToken(token);
		securityUserVerificationDAO.save(p_SecurityUserVerification);
		return token;
	}

	@Override
	public String generateTokenVerification() {
		try {
			return RandomStringGenerator.generate(TOKEN_LENGTH, RandomStringGenerator.Mode.ALPHANUMERIC);
		} catch (Exception e) {
			LOGGER.error("Cannot generate random string for token verification");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean verifyToken(String p_Token) {
		SecurityUserVerification suv = securityUserVerificationDAO.findByToken(p_Token);
		if (suv != null){
			boolean isValid = TimeCalculator.calculateExpiryDate(new Date(), suv.getExpiryDate());
			if (isValid){
				return true;
			}
		}
		return false;
	}

	@Override
	public User findUserByToken(String p_Token) {
		User user = null;
		SecurityUserVerification suv = securityUserVerificationDAO.findByToken(p_Token);
		if (suv != null){
			user = suv.getUser();
		}
		return user;
	}

}
