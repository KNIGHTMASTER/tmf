package id.co.telkomsigma.tmf.data.model.security;

import com.fasterxml.jackson.annotation.JsonBackReference;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;
import id.co.telkomsigma.tmf.data.model.master.contact.SecurityUserContact;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name= TMFConstant.Table.Security.SEC_USER_PROFILE, schema = "bill")
public class SecurityUserProfile extends AAuditTrail {
	/**
	 *
	 * 
	 */
	private static final long serialVersionUID = -1886133679857135012L;

	@JsonBackReference
	private User user;

	private SecurityUserAddress address;

	@JsonBackReference
	private SecurityUserContact contact;

	private String birthPlace;
    private Integer gender;
    private Date birthDate;
	private String photo;
    private String resourceUUID;
    private String forgotUUID;
    private Timestamp forgotExpired;
	private I18NLocale i18NLocale;

	@Column(name="gender")
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name="birth_date")
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setBirthdate(Date birthDate) {
		this.birthDate = new Date(birthDate.getTime());
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	public SecurityUserAddress getAddress() {
		return address;
	}

	public void setAddress(SecurityUserAddress address) {
		this.address = address;
	}

	@Column(name="profile_photo")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name="resource_uuid")
	public String getResourceUUID() {
		return resourceUUID;
	}

	public void setResourceUUID(String resourceUUID) {
		this.resourceUUID = resourceUUID;
	}

	@Column(name="forgot_uuid")
	public String getForgotUUID() {
		return forgotUUID;
	}

	public void setForgotUUID(String forgotUUID) {
		this.forgotUUID = forgotUUID;
	}

	@Column(name="forgot_expired")
	public Timestamp getForgotExpired() {
		return forgotExpired;
	}

	public void setForgotExpired(Timestamp forgotExpired) {
		this.forgotExpired = forgotExpired;
	}

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "locale_id", nullable = false)
	public I18NLocale getI18NLocale() {
		return i18NLocale;
	}

	public void setI18NLocale(I18NLocale i18nLocale) {
		i18NLocale = i18nLocale;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_id")
	public SecurityUserContact getContact() {
		return contact;
	}

	public void setContact(SecurityUserContact contact) {
		this.contact = contact;
	}

	@Column(name = "birth_place", length = 150)
	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	@Override
	public String tableName() {
		return TMFConstant.Table.Security.SEC_USER_PROFILE;
	}

	@Override
	public String toString() {
		return "SecurityUserProfile{" +
				"address=" + address +
				", contact=" + contact +
				", user=" + user +
				", birthPlace='" + birthPlace + '\'' +
				", gender=" + gender +
				", birthDate=" + birthDate +
				", photo='" + photo + '\'' +
				", resourceUUID='" + resourceUUID + '\'' +
				", forgotUUID='" + forgotUUID + '\'' +
				", forgotExpired=" + forgotExpired +
				", i18NLocale=" + i18NLocale +
				'}';
	}
}
