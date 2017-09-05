package id.co.telkomsigma.tmf.data.model.security;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = TMFConstant.Table.Security.SEC_COMPANY)
public class SecurityCompany extends AAuditTrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6328692326564037786L;

	@Override
	public String tableName() {
		return TMFConstant.Table.Security.SEC_COMPANY;
	}	

}
