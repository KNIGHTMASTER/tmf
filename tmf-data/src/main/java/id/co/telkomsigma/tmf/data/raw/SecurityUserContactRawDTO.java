package id.co.telkomsigma.tmf.data.raw;

import id.co.telkomsigma.tmf.data.dto.response.AAuditTrailsResponseDTO;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class SecurityUserContactRawDTO extends AAuditTrailsResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = 3169990997458110714L;

    private String personalNumber;
    private String phoneNumber1;
    private String phoneNumber2;
    private String faxNumber;
    private String email;
    private CountryRawDTO country;

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CountryRawDTO getCountry() {
        return country;
    }

    public void setCountry(CountryRawDTO country) {
        this.country = country;
    }
}
