package id.co.telkomsigma.tmf.security.policy;

import org.passay.PasswordValidator;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IPasswordPolicy {

    PasswordValidator generatePasswordValidator();

    boolean isValid(String p_Password);
}
