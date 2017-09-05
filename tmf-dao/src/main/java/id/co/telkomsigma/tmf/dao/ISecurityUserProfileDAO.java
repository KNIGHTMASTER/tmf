package id.co.telkomsigma.tmf.dao;

import id.co.telkomsigma.tmf.dao.scaffolding.IScaffoldingDAO;
import id.co.telkomsigma.tmf.data.model.master.contact.SecurityUserContact;
import id.co.telkomsigma.tmf.data.model.security.I18NLocale;
import id.co.telkomsigma.tmf.data.model.security.SecurityUserProfile;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ISecurityUserProfileDAO extends IScaffoldingDAO<SecurityUserProfile> {

	/*Query("SELECT a FROM SecurityUserProfile a WHERE a.id = ?1")*/
	SecurityUserProfile findById(Long p_ID);

	@Query("SELECT a FROM SecurityUserProfile a JOIN a.contact b where b.email = ?1")
	SecurityUserProfile findByEmail(String p_Email);

	@Query("SELECT a FROM SecurityUserProfile a JOIN a.contact b where b.phoneNumber1 = ?1 or b.phoneNumber2 = ?2")
	SecurityUserProfile findByPhone(String p_Phone);

	@Query(value = "SELECT p FROM SecurityUserProfile p WHERE p.user.username = :username or p.contact.email = :email")
	public SecurityUserProfile findByUsernameOrEmail(@Param(value = "username") String username, @Param(value = "email") String p_Email);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE SecurityUserProfile SET i18NLocale = :i18NLocale WHERE user = (SELECT u FROM User u WHERE u.username = :username)")
	public int setProfileLocale(@Param(value = "i18NLocale") I18NLocale i18NLocale,
								@Param(value = "username") String username);

	SecurityUserProfile findByContact(SecurityUserContact p_SecurityUserContact);
		
}
