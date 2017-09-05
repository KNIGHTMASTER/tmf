package id.co.telkomsigma.tmf.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 *
 * Created on 8/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * <p>
 *     Thrown when token cannot be found in the request header
 * </p>
 */
public class JwtTokenMissingException extends AuthenticationException {
    /**
     *
     *
     */
    private static final long serialVersionUID = 4188901113131363056L;

    public JwtTokenMissingException(String msg) {
        super(msg);
    }
}
