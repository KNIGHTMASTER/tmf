package id.co.telkomsigma.tmf.data.model.security;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name= TMFConstant.Table.Security.SEC_LOCALE)
public class I18NLocale extends AAuditTrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6939714779428715474L;	
	   
	@Override
	public String tableName() {
		return TMFConstant.Table.Security.SEC_LOCALE;
	}

}
