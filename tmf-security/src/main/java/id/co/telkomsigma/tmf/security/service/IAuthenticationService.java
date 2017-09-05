package id.co.telkomsigma.tmf.security.service;

import id.co.telkomsigma.tmf.data.model.security.SecurityUserDetails;

/**
 * Created on 9/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IAuthenticationService {

    SecurityUserDetails login(String username) throws Exception;

    int change(String username, String secret) throws Exception;
}
