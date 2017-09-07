package id.co.telkomsigma.tmf.data.model.security;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = TMFConstant.Table.Security.SEC_GROUP)
public class SecurityGroup extends AAuditTrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7642774819235324495L;

	@Override
	public String tableName() {
		return TMFConstant.Table.Security.SEC_GROUP;
	}
	
	@Column(name = "first_menu")
	@Access(AccessType.FIELD)
	private Integer firstMenu;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "branch_id")
	@Access(AccessType.FIELD)
	@JsonBackReference
	private SecurityBranch branch;

	@ManyToOne
	@JoinColumn(name = "role_id")
	@Access(AccessType.FIELD)
	private Role role;

	@JsonManagedReference
	private Set<User> users;

	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getFirstMenu() {
		return firstMenu;
	}

	public void setFirstMenu(Integer firstMenu) {
		this.firstMenu = firstMenu;
	}

	public SecurityBranch getBranch() {
		return branch;
	}

	public void setBranch(SecurityBranch branch) {
		this.branch = branch;
	}

	/*@Override
	public String toString() {
		return "SecurityGroup{" +
				"firstMenu=" + firstMenu +
				", branch=" + branch +
				", role=" + role +
				'}';
	}*/
}
