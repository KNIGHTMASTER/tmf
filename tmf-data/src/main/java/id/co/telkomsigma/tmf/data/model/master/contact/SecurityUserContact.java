package id.co.telkomsigma.tmf.data.model.master.contact;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;
import id.co.telkomsigma.tmf.data.model.master.country.Country;
import id.co.telkomsigma.tmf.data.model.security.SecurityUserProfile;

import javax.persistence.*;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TMFConstant.Table.Security.SEC_USER_CONTACT, schema = "bill")
public class SecurityUserContact extends AAuditTrail {
    private static final long serialVersionUID = 6804239567456143530L;

    @Override
    public String tableName() {
        return TMFConstant.Table.Security.SEC_USER_CONTACT;
    }

    private String personalNumber;
    private String phoneNumber1;
    private String phoneNumber2;
    private String faxNumber;
    private String email;
    private Country country;

    @JsonManagedReference
    private SecurityUserProfile securityUserProfile;

    @Column(name = "personal_number")
    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    @Column(name = "phone_number_1")
    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    @Column(name = "phone_number_2")
    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    @Column(name = "fax_number")
    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
    @OneToOne(mappedBy = "contact", fetch = FetchType.LAZY)
	public SecurityUserProfile getSecurityUserProfile() {
		return securityUserProfile;
	}

	public void setSecurityUserProfile(SecurityUserProfile securityUserProfile) {
		this.securityUserProfile = securityUserProfile;
	}

	@Override
    public String toString() {
        return "SecurityContact{" +
                "personalNumber='" + personalNumber + '\'' +
                ", phoneNumber1='" + phoneNumber1 + '\'' +
                ", phoneNumber2='" + phoneNumber2 + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                ", email='" + email + '\'' +
                ", country=" + country +
                '}';
    }
}
