package id.co.telkomsigma.tmf.data.mapper;

import id.co.telkomsigma.tmf.data.model.security.SecurityUserDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created on 9/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class SecurityUserDetailsMapper implements RowMapper<SecurityUserDetails> {

    @Override
    public SecurityUserDetails mapRow(ResultSet rs, int i) throws SQLException {
        SecurityUserDetails securityUserDetails = new SecurityUserDetails();
        securityUserDetails.setUsername(rs.getString("client_id"));
        securityUserDetails.setPassword(rs.getString("client_secret"));
        securityUserDetails.setEnabled(getBoolean(rs.getInt("user_enabled")));
        securityUserDetails.setAccountNonExpired(getBoolean(rs.getDate("user_expired_date")));
        securityUserDetails.setCredentialsNonExpired(getBoolean(rs.getDate("user_credentials_expired_date")));
        securityUserDetails.setAccountNonLocked(getBoolean(rs.getInt("user_non_locked")));
        securityUserDetails.setAuthorities(rs.getString("code"));
        return securityUserDetails;
    }

    private boolean getBoolean(int data) {
        return data == 1 ? true : false;
    }

    private boolean getBoolean(Date date) {
        if(date != null){
            if(date.compareTo(new Date(new java.util.Date().getTime())) >= 0)
                return true;
            else
                return false;
        }else
            return true;
    }
}
