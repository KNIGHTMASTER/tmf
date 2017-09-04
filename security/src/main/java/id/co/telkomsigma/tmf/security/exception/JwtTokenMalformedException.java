package id.co.telkomsigma.tmf.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 *
 * Created on 8/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * <p>
 *     Thrown when token cannot be parsed
 * </p>
 */
public class JwtTokenMalformedException extends AuthenticationException {
    /**
     *
     *
     */
    private static final long serialVersionUID = 8291344884992920490L;

    public JwtTokenMalformedException(String msg) {
        super(msg);
    }
}
