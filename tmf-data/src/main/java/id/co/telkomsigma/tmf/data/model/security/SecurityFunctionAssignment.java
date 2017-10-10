package id.co.telkomsigma.tmf.data.model.security;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;

import javax.persistence.*;

@Entity
@Table(name = TMFConstant.Table.Security.SEC_FUNCTION_ASSIGNMENT, schema = "bill")
public class SecurityFunctionAssignment extends AAuditTrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = 305279356967223971L;

	@Override
	public String tableName() {
		return TMFConstant.Table.Security.SEC_FUNCTION_ASSIGNMENT;
	}

	private Integer assignmentOrder;
	private String actionType;
	private SecurityFunction function;
	private SecurityGroup group;

	@Column(name = "assignment_order")
	public Integer getAssignmentOrder() {
		return assignmentOrder;
	}

	public void setAssignmentOrder(Integer assignmentOrder) {
		this.assignmentOrder = assignmentOrder;
	}

	@Column(name = "action_type", length = 150)
	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	@ManyToOne
	@JoinColumn(name = "function_id")
	public SecurityFunction getFunction() {
		return function;
	}

	public void setFunction(SecurityFunction function) {
		this.function = function;
	}

	@ManyToOne
	@JoinColumn(name = "group_id")
	public SecurityGroup getGroup() {
		return group;
	}

	public void setGroup(SecurityGroup group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "SecurityFunctionAssignment [assignmentOrder=" + assignmentOrder + ", actionType=" + actionType
				+ ", function=" + function + ", group=" + group + "]";
	}
	
	

}
