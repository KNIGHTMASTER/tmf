package id.co.telkomsigma.tmf.service.util.impl;


import id.co.telkomsigma.tmf.dao.ISecurityUserProfileDAO;
import id.co.telkomsigma.tmf.data.model.security.SecurityUserProfile;
import id.co.telkomsigma.tmf.service.util.IEmailValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * created on 1/20/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class EmailValidationImpl implements IEmailValidation {

    @Autowired
    ISecurityUserProfileDAO securityUserProfileDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailValidationImpl.class);

    @Override
    public boolean validateByString(String p_Email) {
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        p_Email = p_Email.trim();
        return p_Email.matches(emailPattern) && p_Email.length() > 0;
    }

    @Override
    public boolean validateByData(String p_Email) {
        SecurityUserProfile sup = securityUserProfileDao.findByEmail(p_Email);
        return sup != null;
    }

    @Override
    public boolean validateAll(String p_Email) {
        return validateByString(p_Email) && validateByInternet(p_Email) && validateByData(p_Email);
    }

    @Override
    public boolean validateByInternet(String p_Email) {
        try {
            InternetAddress internetAddress = new InternetAddress(p_Email);
            internetAddress.validate();
            return true;
        } catch (AddressException e) {
            LOGGER.error("Email is not valid / available");
            return false;
        }
    }

    @Override
    public boolean isReadyToRegister(String p_Email) {
        return validateByString(p_Email) && validateByInternet(p_Email) && !validateByData(p_Email);
    }
}
