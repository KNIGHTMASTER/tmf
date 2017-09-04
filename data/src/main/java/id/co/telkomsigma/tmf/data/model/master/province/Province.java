package id.co.telkomsigma.tmf.data.model.master.province;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;
import id.co.telkomsigma.tmf.data.model.master.city.City;
import id.co.telkomsigma.tmf.data.model.master.country.Country;

import javax.persistence.*;
import java.util.Set;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TMFConstant.Table.Master.MST_PROVINCE)
public class Province extends AAuditTrail {
    private static final long serialVersionUID = 4877117558375920984L;

    private Country country;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
    public String tableName() {
        return TMFConstant.Table.Master.MST_PROVINCE;
    }

    private Set<City> cities;

    @OneToMany(mappedBy = "province", fetch = FetchType.EAGER)
	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
    
    
}
