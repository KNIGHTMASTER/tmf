package id.co.telkomsigma.tmf.data.model.system;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = TMFConstant.Table.System.SYS_PARAMETER_GROUP)
public class SystemParameterGroup extends AAuditTrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5715517653490981393L;

	private Set<SystemParameter> systemParameters;
	
	@Override
	public String tableName() {
		return TMFConstant.Table.System.SYS_PARAMETER_GROUP;
	}

	@OneToMany(mappedBy = "parameterGroup", fetch = FetchType.EAGER)
	public Set<SystemParameter> getSystemParameters() {
		return systemParameters;
	}

	public void setSystemParameters(Set<SystemParameter> systemParameters) {
		this.systemParameters = systemParameters;
	}

	@Override
	public String toString() {
		return "SystemParameterGroup [status=" + status + ", remarks=" + remarks + ", createdBy=" + createdBy
				+ ", createdIP=" + createdIP + ", createdOn=" + createdOn + ", createdPlatform=" + createdPlatform
				+ ", modifiedBy=" + modifiedBy + ", modifiedIP=" + modifiedIP + ", modifiedOn=" + modifiedOn
				+ ", modifiedPlatform=" + modifiedPlatform + "]";
	}
	
	

}
