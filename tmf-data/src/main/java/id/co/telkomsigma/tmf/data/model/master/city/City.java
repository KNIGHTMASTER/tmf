package id.co.telkomsigma.tmf.data.model.master.city;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;
import id.co.telkomsigma.tmf.data.model.master.district.District;
import id.co.telkomsigma.tmf.data.model.master.province.Province;

import javax.persistence.*;
import java.util.Set;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TMFConstant.Table.Master.MST_CITY)
public class City extends AAuditTrail {
	
	/**
	 * 
	 * 
	 */
    private static final long serialVersionUID = -5329991434389083265L;

    @Override
    public String tableName() {
        return TMFConstant.Table.Master.MST_CITY;
    }

    @JsonBackReference
    private Province province;

    @JsonManagedReference
    private Set<District> districts;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    public Set<District> getDistricts() {
		return districts;
	}

	public void setDistricts(Set<District> districts) {
		this.districts = districts;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "City{" +
                "province=" + province +
                '}';
    }
}
