package id.co.telkomsigma.tmf.dao.jdbc;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.mapper.SecurityUserDetailsMapper;
import id.co.telkomsigma.tmf.data.model.security.SecurityUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Created on 9/3/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Repository
public class AuthenticationDAOImpl implements IAuthenticationDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final RowMapper<SecurityUserDetails> securityUserDetailsMapper = new SecurityUserDetailsMapper();

    @Override
    public SecurityUserDetails login(String p_UserName1, String p_UserName2, String p_UserName3) {
        return jdbcTemplate.queryForObject(TMFConstant.Query.LOGIN, new Object[]{p_UserName1, p_UserName2, p_UserName3}, securityUserDetailsMapper);
    }

    @Override
    public int authenticationChange(String p_Secret, String p_UserName) {
        return jdbcTemplate.update(TMFConstant.Query.AUTHENTICATION_CHANGE, p_Secret, p_UserName);
    }
}
