package id.co.telkomsigma.tmf.security.transfer;

import java.io.Serializable;

/**
 * Created on 8/30/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * <p>
 *  Simple placeholder for info extracted from the JWT
 * </p>
 */
public class JwtUserDto implements Serializable {
    /**
     *
     *
     */
    private static final long serialVersionUID = -7262598212222349203L;

    private String username;

    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "JwtUserDto{" +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}