package id.co.telkomsigma.tmf.data.raw;

import id.co.telkomsigma.tmf.data.dto.response.AAuditTrailsResponseDTO;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class SecurityUserProfileRawDTO extends AAuditTrailsResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = -6470199450034194740L;

    private String birthPlace;
    private Integer gender;
    private Date birthDate;
    private String photo;
    private String resourceUUID;
    private String forgotUUID;
    private Timestamp forgotExpired;
    private I18NLocaleRawDTO i18NLocale;

    private SecurityUserContactRawDTO contact;
    private SecurityUserAddressRawDTO address;

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getResourceUUID() {
        return resourceUUID;
    }

    public void setResourceUUID(String resourceUUID) {
        this.resourceUUID = resourceUUID;
    }

    public String getForgotUUID() {
        return forgotUUID;
    }

    public void setForgotUUID(String forgotUUID) {
        this.forgotUUID = forgotUUID;
    }

    public Timestamp getForgotExpired() {
        return forgotExpired;
    }

    public void setForgotExpired(Timestamp forgotExpired) {
        this.forgotExpired = forgotExpired;
    }

    public I18NLocaleRawDTO getI18NLocale() {
        return i18NLocale;
    }

    public void setI18NLocale(I18NLocaleRawDTO i18NLocale) {
        this.i18NLocale = i18NLocale;
    }

    public SecurityUserContactRawDTO getContact() {
        return contact;
    }

    public void setContact(SecurityUserContactRawDTO contact) {
        this.contact = contact;
    }

    public SecurityUserAddressRawDTO getAddress() {
        return address;
    }

    public void setAddress(SecurityUserAddressRawDTO address) {
        this.address = address;
    }
}
