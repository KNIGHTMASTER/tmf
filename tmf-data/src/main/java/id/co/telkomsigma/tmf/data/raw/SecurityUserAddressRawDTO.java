package id.co.telkomsigma.tmf.data.raw;

import id.co.telkomsigma.tmf.data.dto.response.AAuditTrailsResponseDTO;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class SecurityUserAddressRawDTO extends AAuditTrailsResponseDTO {
    /**
     *
     *
     */
    private static final long serialVersionUID = -8529359757305479812L;

    private String detailAddress;
    private String postalCode;
    private CountryRawDTO country;
    private ProvinceRawDTO province;
    private CityRawDTO city;
    private DistrictRawDTO district;
    private VillageRawDTO village;

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public CountryRawDTO getCountry() {
        return country;
    }

    public void setCountry(CountryRawDTO country) {
        this.country = country;
    }

    public ProvinceRawDTO getProvince() {
        return province;
    }

    public void setProvince(ProvinceRawDTO province) {
        this.province = province;
    }

    public CityRawDTO getCity() {
        return city;
    }

    public void setCity(CityRawDTO city) {
        this.city = city;
    }

    public DistrictRawDTO getDistrict() {
        return district;
    }

    public void setDistrict(DistrictRawDTO district) {
        this.district = district;
    }

    public VillageRawDTO getVillage() {
        return village;
    }

    public void setVillage(VillageRawDTO village) {
        this.village = village;
    }
}
