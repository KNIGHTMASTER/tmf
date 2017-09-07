package id.co.telkomsigma.tmf.data.model.security;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

	@JsonBackReference
	private SecurityCompany company;

	@JsonManagedReference
	private Set<SecurityGroup> securityGroups = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	public SecurityCompany getCompany() {
		return company;
	}

	public void setCompany(SecurityCompany company) {
		this.company = company;
	}


	@OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
	public Set<SecurityGroup> getSecurityGroups() {
		return securityGroups;
	}

	public void setSecurityGroups(Set<SecurityGroup> securityGroups) {
		this.securityGroups = securityGroups;
	}

	/*@Override
	public String toString() {
		return "SecurityBranch{" +
				"company=" + company +
				", securityGroups=" + expandGroups(securityGroups) +
				'}';
	}

	String expandGroups(Set<SecurityGroup> securityGroups){
		String result = "";
		for (SecurityGroup securityGroup : securityGroups){
			result += securityGroup.toString();
		}
		return result;
	}*/
}
