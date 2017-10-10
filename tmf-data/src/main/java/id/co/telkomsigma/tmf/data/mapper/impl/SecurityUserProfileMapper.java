package id.co.telkomsigma.tmf.data.mapper.impl;

import id.co.telkomsigma.tmf.data.mapper.ADATAMapper;
import id.co.telkomsigma.tmf.data.model.security.SecurityUserProfile;
import id.co.telkomsigma.tmf.data.raw.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class SecurityUserProfileMapper extends ADATAMapper<SecurityUserProfile, SecurityUserProfileRawDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUserProfileMapper.class);

    @Override
    public SecurityUserProfileRawDTO convert(SecurityUserProfile securityUserProfile) {
        SecurityUserProfileRawDTO result = new SecurityUserProfileRawDTO();
        try{
            result.setId(securityUserProfile.getId());
            result.setCode(securityUserProfile.getCode());
            result.setName(securityUserProfile.getName());
            result.setStatus(securityUserProfile.getStatus());
            result.setRemarks(securityUserProfile.getRemarks());
            result.setCreatedBy(securityUserProfile.getCreatedBy());
            result.setCreatedIP(securityUserProfile.getCreatedIP());
            result.setCreatedOn(securityUserProfile.getCreatedOn());
            result.setCreatedPlatform(securityUserProfile.getCreatedPlatform());
            result.setModifiedBy(securityUserProfile.getModifiedBy());
            result.setModifiedIP(securityUserProfile.getModifiedIP());
            result.setModifiedOn(securityUserProfile.getModifiedOn());
            result.setModifiedPlatform(securityUserProfile.getModifiedPlatform());
            result.setBirthPlace(securityUserProfile.getBirthPlace());
            result.setGender(securityUserProfile.getGender());
            result.setBirthDate(securityUserProfile.getBirthDate());
            result.setPhoto(securityUserProfile.getPhoto());
            result.setResourceUUID(securityUserProfile.getResourceUUID());
            result.setForgotUUID(securityUserProfile.getForgotUUID());
            result.setForgotExpired(securityUserProfile.getForgotExpired());
            if (securityUserProfile.getI18NLocale() != null) {
                I18NLocaleRawDTO i18NLocaleRawDTO = new I18NLocaleRawDTO();
                i18NLocaleRawDTO.setId(securityUserProfile.getI18NLocale().getId());
                i18NLocaleRawDTO.setCode(securityUserProfile.getI18NLocale().getCode());
                i18NLocaleRawDTO.setName(securityUserProfile.getI18NLocale().getName());
                i18NLocaleRawDTO.setStatus(securityUserProfile.getI18NLocale().getStatus());
                i18NLocaleRawDTO.setRemarks(securityUserProfile.getI18NLocale().getRemarks());
                i18NLocaleRawDTO.setCreatedBy(securityUserProfile.getI18NLocale().getCreatedBy());
                i18NLocaleRawDTO.setCreatedIP(securityUserProfile.getI18NLocale().getCreatedIP());
                i18NLocaleRawDTO.setCreatedOn(securityUserProfile.getI18NLocale().getCreatedOn());
                i18NLocaleRawDTO.setCreatedPlatform(securityUserProfile.getI18NLocale().getCreatedPlatform());
                i18NLocaleRawDTO.setModifiedBy(securityUserProfile.getI18NLocale().getModifiedBy());
                i18NLocaleRawDTO.setModifiedIP(securityUserProfile.getI18NLocale().getModifiedIP());
                i18NLocaleRawDTO.setModifiedOn(securityUserProfile.getI18NLocale().getModifiedOn());
                i18NLocaleRawDTO.setModifiedPlatform(securityUserProfile.getI18NLocale().getModifiedPlatform());
                result.setI18NLocale(i18NLocaleRawDTO);
            }
            if (securityUserProfile.getAddress() != null){
                SecurityUserAddressRawDTO addressRawDTO = new SecurityUserAddressRawDTO();
                addressRawDTO.setId(securityUserProfile.getAddress().getId());
                addressRawDTO.setCode(securityUserProfile.getAddress().getCode());
                addressRawDTO.setName(securityUserProfile.getAddress().getName());
                addressRawDTO.setStatus(securityUserProfile.getAddress().getStatus());
                addressRawDTO.setRemarks(securityUserProfile.getAddress().getRemarks());
                addressRawDTO.setCreatedBy(securityUserProfile.getAddress().getCreatedBy());
                addressRawDTO.setCreatedIP(securityUserProfile.getAddress().getCreatedIP());
                addressRawDTO.setCreatedOn(securityUserProfile.getAddress().getCreatedOn());
                addressRawDTO.setCreatedPlatform(securityUserProfile.getAddress().getCreatedPlatform());
                addressRawDTO.setModifiedBy(securityUserProfile.getAddress().getModifiedBy());
                addressRawDTO.setModifiedIP(securityUserProfile.getAddress().getModifiedIP());
                addressRawDTO.setModifiedOn(securityUserProfile.getAddress().getModifiedOn());
                addressRawDTO.setModifiedPlatform(securityUserProfile.getAddress().getModifiedPlatform());
                addressRawDTO.setDetailAddress(securityUserProfile.getAddress().getDetailAddress());
                addressRawDTO.setPostalCode(securityUserProfile.getAddress().getPostalCode());

                if (securityUserProfile.getAddress().getCountry() != null) {
                    CountryRawDTO countryRawDTO = new CountryRawDTO();
                    countryRawDTO.setId(securityUserProfile.getAddress().getCountry().getId());
                    countryRawDTO.setCode(securityUserProfile.getAddress().getCountry().getCode());
                    countryRawDTO.setName(securityUserProfile.getAddress().getCountry().getName());
                    countryRawDTO.setStatus(securityUserProfile.getAddress().getCountry().getStatus());
                    countryRawDTO.setRemarks(securityUserProfile.getAddress().getCountry().getRemarks());
                    countryRawDTO.setCreatedBy(securityUserProfile.getAddress().getCountry().getCreatedBy());
                    countryRawDTO.setCreatedIP(securityUserProfile.getAddress().getCountry().getCreatedIP());
                    countryRawDTO.setCreatedOn(securityUserProfile.getAddress().getCountry().getCreatedOn());
                    countryRawDTO.setCreatedPlatform(securityUserProfile.getAddress().getCountry().getCreatedPlatform());
                    countryRawDTO.setModifiedBy(securityUserProfile.getAddress().getCountry().getModifiedBy());
                    countryRawDTO.setModifiedIP(securityUserProfile.getAddress().getCountry().getModifiedIP());
                    countryRawDTO.setModifiedOn(securityUserProfile.getAddress().getCountry().getModifiedOn());
                    countryRawDTO.setModifiedPlatform(securityUserProfile.getAddress().getCountry().getModifiedPlatform());
                    addressRawDTO.setCountry(countryRawDTO);
                }

                if (securityUserProfile.getAddress().getProvince() != null) {
                    ProvinceRawDTO provinceRawDTO = new ProvinceRawDTO();
                    provinceRawDTO.setId(securityUserProfile.getAddress().getProvince().getId());
                    provinceRawDTO.setCode(securityUserProfile.getAddress().getProvince().getCode());
                    provinceRawDTO.setName(securityUserProfile.getAddress().getProvince().getName());
                    provinceRawDTO.setStatus(securityUserProfile.getAddress().getProvince().getStatus());
                    provinceRawDTO.setRemarks(securityUserProfile.getAddress().getProvince().getRemarks());
                    provinceRawDTO.setCreatedBy(securityUserProfile.getAddress().getProvince().getCreatedBy());
                    provinceRawDTO.setCreatedIP(securityUserProfile.getAddress().getProvince().getCreatedIP());
                    provinceRawDTO.setCreatedOn(securityUserProfile.getAddress().getProvince().getCreatedOn());
                    provinceRawDTO.setCreatedPlatform(securityUserProfile.getAddress().getProvince().getCreatedPlatform());
                    provinceRawDTO.setModifiedBy(securityUserProfile.getAddress().getProvince().getModifiedBy());
                    provinceRawDTO.setModifiedIP(securityUserProfile.getAddress().getProvince().getModifiedIP());
                    provinceRawDTO.setModifiedOn(securityUserProfile.getAddress().getProvince().getModifiedOn());
                    provinceRawDTO.setModifiedPlatform(securityUserProfile.getAddress().getProvince().getModifiedPlatform());
                    addressRawDTO.setProvince(provinceRawDTO);
                }

                if (securityUserProfile.getAddress().getCity() != null) {
                    CityRawDTO cityRawDTO = new CityRawDTO();
                    cityRawDTO.setId(securityUserProfile.getAddress().getCity().getId());
                    cityRawDTO.setCode(securityUserProfile.getAddress().getCity().getCode());
                    cityRawDTO.setName(securityUserProfile.getAddress().getCity().getName());
                    cityRawDTO.setStatus(securityUserProfile.getAddress().getCity().getStatus());
                    cityRawDTO.setRemarks(securityUserProfile.getAddress().getCity().getRemarks());
                    cityRawDTO.setCreatedBy(securityUserProfile.getAddress().getCity().getCreatedBy());
                    cityRawDTO.setCreatedIP(securityUserProfile.getAddress().getCity().getCreatedIP());
                    cityRawDTO.setCreatedOn(securityUserProfile.getAddress().getCity().getCreatedOn());
                    cityRawDTO.setCreatedPlatform(securityUserProfile.getAddress().getCity().getCreatedPlatform());
                    cityRawDTO.setModifiedBy(securityUserProfile.getAddress().getCity().getModifiedBy());
                    cityRawDTO.setModifiedIP(securityUserProfile.getAddress().getCity().getModifiedIP());
                    cityRawDTO.setModifiedOn(securityUserProfile.getAddress().getCity().getModifiedOn());
                    cityRawDTO.setModifiedPlatform(securityUserProfile.getAddress().getCity().getModifiedPlatform());
                    addressRawDTO.setCity(cityRawDTO);
                }

                if (securityUserProfile.getAddress().getDistrict() != null) {
                    DistrictRawDTO districtRawDTO = new DistrictRawDTO();
                    districtRawDTO.setId(securityUserProfile.getAddress().getDistrict().getId());
                    districtRawDTO.setCode(securityUserProfile.getAddress().getDistrict().getCode());
                    districtRawDTO.setName(securityUserProfile.getAddress().getDistrict().getName());
                    districtRawDTO.setStatus(securityUserProfile.getAddress().getDistrict().getStatus());
                    districtRawDTO.setRemarks(securityUserProfile.getAddress().getDistrict().getRemarks());
                    districtRawDTO.setCreatedBy(securityUserProfile.getAddress().getDistrict().getCreatedBy());
                    districtRawDTO.setCreatedIP(securityUserProfile.getAddress().getDistrict().getCreatedIP());
                    districtRawDTO.setCreatedOn(securityUserProfile.getAddress().getDistrict().getCreatedOn());
                    districtRawDTO.setCreatedPlatform(securityUserProfile.getAddress().getDistrict().getCreatedPlatform());
                    districtRawDTO.setModifiedBy(securityUserProfile.getAddress().getDistrict().getModifiedBy());
                    districtRawDTO.setModifiedIP(securityUserProfile.getAddress().getDistrict().getModifiedIP());
                    districtRawDTO.setModifiedOn(securityUserProfile.getAddress().getDistrict().getModifiedOn());
                    districtRawDTO.setModifiedPlatform(securityUserProfile.getAddress().getDistrict().getModifiedPlatform());
                    addressRawDTO.setDistrict(districtRawDTO);
                }

                if (securityUserProfile.getAddress().getVillage() != null) {
                    VillageRawDTO villageRawDTO = new VillageRawDTO();
                    villageRawDTO.setId(securityUserProfile.getAddress().getVillage().getId());
                    villageRawDTO.setCode(securityUserProfile.getAddress().getVillage().getCode());
                    villageRawDTO.setName(securityUserProfile.getAddress().getVillage().getName());
                    villageRawDTO.setStatus(securityUserProfile.getAddress().getVillage().getStatus());
                    villageRawDTO.setRemarks(securityUserProfile.getAddress().getVillage().getRemarks());
                    villageRawDTO.setCreatedBy(securityUserProfile.getAddress().getVillage().getCreatedBy());
                    villageRawDTO.setCreatedIP(securityUserProfile.getAddress().getVillage().getCreatedIP());
                    villageRawDTO.setCreatedOn(securityUserProfile.getAddress().getVillage().getCreatedOn());
                    villageRawDTO.setCreatedPlatform(securityUserProfile.getAddress().getVillage().getCreatedPlatform());
                    villageRawDTO.setModifiedBy(securityUserProfile.getAddress().getVillage().getModifiedBy());
                    villageRawDTO.setModifiedIP(securityUserProfile.getAddress().getVillage().getModifiedIP());
                    villageRawDTO.setModifiedOn(securityUserProfile.getAddress().getVillage().getModifiedOn());
                    villageRawDTO.setModifiedPlatform(securityUserProfile.getAddress().getVillage().getModifiedPlatform());
                    addressRawDTO.setVillage(villageRawDTO);
                }
                result.setAddress(addressRawDTO);
            }
            if (securityUserProfile.getContact() != null) {
                SecurityUserContactRawDTO contactRawDTO = new SecurityUserContactRawDTO();
                contactRawDTO.setId(securityUserProfile.getContact().getId());
                contactRawDTO.setCode(securityUserProfile.getContact().getCode());
                contactRawDTO.setName(securityUserProfile.getContact().getName());
                contactRawDTO.setStatus(securityUserProfile.getContact().getStatus());
                contactRawDTO.setRemarks(securityUserProfile.getContact().getRemarks());
                contactRawDTO.setCreatedBy(securityUserProfile.getContact().getCreatedBy());
                contactRawDTO.setCreatedIP(securityUserProfile.getContact().getCreatedIP());
                contactRawDTO.setCreatedOn(securityUserProfile.getContact().getCreatedOn());
                contactRawDTO.setCreatedPlatform(securityUserProfile.getContact().getCreatedPlatform());
                contactRawDTO.setModifiedBy(securityUserProfile.getContact().getModifiedBy());
                contactRawDTO.setModifiedIP(securityUserProfile.getContact().getModifiedIP());
                contactRawDTO.setModifiedOn(securityUserProfile.getContact().getModifiedOn());
                contactRawDTO.setModifiedPlatform(securityUserProfile.getContact().getModifiedPlatform());
                contactRawDTO.setPersonalNumber(securityUserProfile.getContact().getPersonalNumber());
                contactRawDTO.setPhoneNumber1(securityUserProfile.getContact().getPhoneNumber1());
                contactRawDTO.setPhoneNumber2(securityUserProfile.getContact().getPhoneNumber2());
                contactRawDTO.setFaxNumber(securityUserProfile.getContact().getFaxNumber());
                contactRawDTO.setEmail(securityUserProfile.getContact().getEmail());

                if (securityUserProfile.getContact().getCountry() != null) {
                    CountryRawDTO countryRawDTO = new CountryRawDTO();
                    countryRawDTO.setId(securityUserProfile.getContact().getCountry().getId());
                    countryRawDTO.setCode(securityUserProfile.getContact().getCountry().getCode());
                    countryRawDTO.setName(securityUserProfile.getContact().getCountry().getName());
                    countryRawDTO.setStatus(securityUserProfile.getContact().getCountry().getStatus());
                    countryRawDTO.setRemarks(securityUserProfile.getContact().getCountry().getRemarks());
                    countryRawDTO.setCreatedBy(securityUserProfile.getContact().getCountry().getCreatedBy());
                    countryRawDTO.setCreatedIP(securityUserProfile.getContact().getCountry().getCreatedIP());
                    countryRawDTO.setCreatedOn(securityUserProfile.getContact().getCountry().getCreatedOn());
                    countryRawDTO.setCreatedPlatform(securityUserProfile.getContact().getCountry().getCreatedPlatform());
                    countryRawDTO.setModifiedBy(securityUserProfile.getContact().getCountry().getModifiedBy());
                    countryRawDTO.setModifiedIP(securityUserProfile.getContact().getCountry().getModifiedIP());
                    countryRawDTO.setModifiedOn(securityUserProfile.getContact().getCountry().getModifiedOn());
                    countryRawDTO.setModifiedPlatform(securityUserProfile.getContact().getCountry().getModifiedPlatform());
                    contactRawDTO.setCountry(countryRawDTO);
                }
                result.setContact(contactRawDTO);
            }
        }catch (Exception e){
            LOGGER.error("Error mapping Sec User Profile Failed ".concat(e.toString()));
        }
        return result;
    }
}
