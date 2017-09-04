package id.co.telkomsigma.tmf.security.service;

import id.co.telkomsigma.tmf.dao.jdbc.IAuthenticationDAO;
import id.co.telkomsigma.tmf.data.model.security.SecurityUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 9/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    IAuthenticationDAO authenticationDAO;

    @Override
    public SecurityUserDetails login(String username) throws Exception {
        return authenticationDAO.login(username, username, username);
    }

    @Override
    public int change(String username, String secret) throws Exception {
        return authenticationDAO.authenticationChange(secret, username);
    }
}
