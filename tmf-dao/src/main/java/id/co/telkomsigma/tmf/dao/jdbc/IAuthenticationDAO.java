package id.co.telkomsigma.tmf.dao.jdbc;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.security.SecurityUserDetails;
import org.springframework.data.jpa.repository.Query;

/**
 * Created on 9/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IAuthenticationDAO {

    @Query(TMFConstant.Query.LOGIN)
    SecurityUserDetails login(String p_UserName1, String p_UserName2, String p_UserName3);

    @Query(TMFConstant.Query.AUTHENTICATION_CHANGE)
    int authenticationChange(String p_Secret, String p_UserName);
}
