package id.co.telkomsigma.tmf.data.model.system;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;

import javax.persistence.*;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TMFConstant.Table.System.SYS_PARAMETER)
public class SystemParameter extends AAuditTrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6784713469584117924L;

	@Override
	public String tableName() {
		return TMFConstant.Table.System.SYS_PARAMETER;
	}
		
	private SystemParameterGroup parameterGroup;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parameter_group_id")
	public SystemParameterGroup getParameterGroup() {
		return parameterGroup;
	}

	public void setParameterGroup(SystemParameterGroup parameterGroup) {
		this.parameterGroup = parameterGroup;
	}

	@Override
	public String toString() {
		return "SystemParameter [parameterGroup=" + parameterGroup.toString() + "]";
	}
	
	
}
