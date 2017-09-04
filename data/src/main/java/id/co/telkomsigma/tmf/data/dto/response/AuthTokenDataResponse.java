package id.co.telkomsigma.tmf.data.dto.response;

import java.io.Serializable;

/**
 * Created on 9/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class AuthTokenDataResponse implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -706117846154432963L;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
