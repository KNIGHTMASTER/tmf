package id.co.telkomsigma.tmf.data.model.security;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = TMFConstant.Table.Security.SEC_BRANCH)
public class SecurityBranch extends AAuditTrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3342674389044529781L;

	@Override
	public String tableName() {
		return TMFConstant.Table.Security.SEC_BRANCH;
	}
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	@Access(AccessType.FIELD)
	private SecurityCompany company;

	public SecurityCompany getCompany() {
		return company;
	}

	public void setCompany(SecurityCompany company) {
		this.company = company;
	}

	@OneToMany(mappedBy = "branch", fetch = FetchType.EAGER)
	@Access(AccessType.FIELD)
	private Set<SecurityGroup> securityGroups = new HashSet<>();

	public Set<SecurityGroup> getSecurityGroups() {
		return securityGroups;
	}

	public void setSecurityGroups(Set<SecurityGroup> securityGroups) {
		this.securityGroups = securityGroups;
	}

	@Override
	public String toString() {
		return "SecurityBranche [company=" + company + "]";
	}

	
}
