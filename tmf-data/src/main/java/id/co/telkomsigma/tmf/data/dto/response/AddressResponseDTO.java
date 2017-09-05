package id.co.telkomsigma.tmf.data.dto.response;

import java.io.Serializable;

/**
 * created on 1/9/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class AddressResponseDTO implements Serializable {
    private static final long serialVersionUID = -6115011652299047573L;
    private String detailAddress;
    private String postalCode;
    private CountryResponseDTO country;
    private ProvinceResponseDTO province;
    private CityResponseDTO city;
    private DistrictResponseDTO district;
    private VillageResponseDTO village;

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

    public CountryResponseDTO getCountry() {
        return country;
    }

    public void setCountry(CountryResponseDTO country) {
        this.country = country;
    }

    public ProvinceResponseDTO getProvince() {
        return province;
    }

    public void setProvince(ProvinceResponseDTO province) {
        this.province = province;
    }

    public CityResponseDTO getCity() {
        return city;
    }

    public void setCity(CityResponseDTO city) {
        this.city = city;
    }

    public DistrictResponseDTO getDistrict() {
        return district;
    }

    public void setDistrict(DistrictResponseDTO district) {
        this.district = district;
    }

    public VillageResponseDTO getVillage() {
        return village;
    }

    public void setVillage(VillageResponseDTO village) {
        this.village = village;
    }

    @Override
    public String toString() {
        return "AddressDataResponse{" +
                "detailAddress='" + detailAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country=" + country +
                ", province=" + province +
                ", city=" + city +
                ", district=" + district +
                ", village=" + village +
                '}';
    }
}
