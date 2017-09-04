package id.co.telkomsigma.tmf.data.model.security;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = TMFConstant.Table.Master.MST_COMPANY)
public class Company extends AAuditTrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8752398398784954658L;

	@Override
	public String tableName() {
		return TMFConstant.Table.Master.MST_COMPANY;
	}

}
