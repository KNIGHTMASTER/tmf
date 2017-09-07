package id.co.telkomsigma.tmf.data.model.master.country;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;
import id.co.telkomsigma.tmf.data.model.master.province.Province;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TMFConstant.Table.Master.MST_COUNTRY)
public class Country extends AAuditTrail {
    /**
     *
     *
     */
    private static final long serialVersionUID = -3871254896944959025L;

    @JsonManagedReference
    private Set<Province> province;
    
    @Override
    public String tableName() {
        return TMFConstant.Table.Master.MST_COUNTRY;
    }

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	public Set<Province> getProvince() {
		return province;
	}

	public void setProvince(Set<Province> province) {
		this.province = province;
	}

}
