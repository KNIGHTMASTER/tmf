package id.co.telkomsigma.tmf.data.model.master.province;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

	@JsonBackReference
    private Country country;

	@JsonManagedReference
	private Set<City> cities;

    @ManyToOne(fetch = FetchType.LAZY)
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


    @OneToMany(mappedBy = "province", fetch = FetchType.LAZY)
	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

}
