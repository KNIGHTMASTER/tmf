package id.co.telkomsigma.tmf.data.model.security;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.IBasePojo;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name= TMFConstant.Table.Security.SEC_USER_DETAILS, schema = "bill")
public class User implements IBasePojo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8562964002269118022L;
	private Long id;
	private String username;
	private Integer enabled;
	private Timestamp expiredDate;
	private Timestamp credentialsExpiredDate;
	private Integer nonLocked;
	private Role role;

	@JsonManagedReference
	private SecurityUserProfile securityUserProfile;

	@JsonBackReference
	private SecurityGroup group;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "client_id", unique=true, length = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "user_enabled")
	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	@Column(name = "user_expired_date")
	public Timestamp getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Timestamp expiredDate) {
		this.expiredDate = expiredDate;
	}

	@Column(name = "user_credentials_expired_date")
	public Timestamp getCredentialsExpiredDate() {
		return credentialsExpiredDate;
	}

	public void setCredentialsExpiredDate(Timestamp credentialsExpiredDate) {
		this.credentialsExpiredDate = credentialsExpiredDate;
	}

	@Column(name = "user_non_locked")
	public Integer getNonLocked() {
		return nonLocked;
	}

	public void setNonLocked(Integer nonLocked) {
		this.nonLocked = nonLocked;
	}

	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole() {
		return role;
	}
		
	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id", nullable = false)
	public SecurityGroup getGroup() {
		return group;
	}

	public void setGroup(SecurityGroup group) {
		this.group = group;
	}
		
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
	public SecurityUserProfile getSecurityUserProfile() {
		return securityUserProfile;
	}

	public void setSecurityUserProfile(SecurityUserProfile securityUserProfile) {
		this.securityUserProfile = securityUserProfile;
	}

	@Override
	public String tableName() {
		return TMFConstant.Table.Security.SEC_USER_DETAILS;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (credentialsExpiredDate != null ? !credentialsExpiredDate.equals(user.credentialsExpiredDate) : user.credentialsExpiredDate != null)
			return false;
		if (enabled != null ? !enabled.equals(user.enabled) : user.enabled != null) return false;
		if (expiredDate != null ? !expiredDate.equals(user.expiredDate) : user.expiredDate != null) return false;
		if (group != null ? !group.equals(user.group) : user.group != null) return false;
		if (id != null ? !id.equals(user.id) : user.id != null) return false;
		if (nonLocked != null ? !nonLocked.equals(user.nonLocked) : user.nonLocked != null) return false;
		if (role != null ? !role.equals(user.role) : user.role != null) return false;
		if (username != null ? !username.equals(user.username) : user.username != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (username != null ? username.hashCode() : 0);
		result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
		result = 31 * result + (expiredDate != null ? expiredDate.hashCode() : 0);
		result = 31 * result + (credentialsExpiredDate != null ? credentialsExpiredDate.hashCode() : 0);
		result = 31 * result + (nonLocked != null ? nonLocked.hashCode() : 0);
		result = 31 * result + (role != null ? role.hashCode() : 0);
		result = 31 * result + (group != null ? group.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", enabled=" + enabled +
				", expiredDate=" + expiredDate +
				", credentialsExpiredDate=" + credentialsExpiredDate +
				", nonLocked=" + nonLocked +
				", role=" + role +
				", group=" + group +
				'}';
	}
}
