package id.co.telkomsigma.tmf.data.model.security;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

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

	@JsonManagedReference
	private Set<SecurityBranch> branches;

	@OneToMany(mappedBy = "company")
	public Set<SecurityBranch> getBranches() {
		return branches;
	}

	public void setBranches(Set<SecurityBranch> branches) {
		this.branches = branches;
	}
}
