package id.co.telkomsigma.tmf.data.model.security;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name= TMFConstant.Table.Security.SEC_ROLE, schema = "bill")
public class Role extends AAuditTrail implements GrantedAuthority {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5208531126588851646L;
	
	public Role() {}
	
	public Role(String authority) {
		setCode(authority);
	}
	
	@Override
	public String getAuthority() {
		return getCode();
	}

	public void setAuthority(String authority) {
		setCode(authority);
	}

	@Override
	public String tableName() {
		return TMFConstant.Table.Security.SEC_ROLE;
	}
	
}
