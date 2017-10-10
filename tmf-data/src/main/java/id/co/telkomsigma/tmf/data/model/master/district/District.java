package id.co.telkomsigma.tmf.data.model.master.district;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;
import id.co.telkomsigma.tmf.data.model.master.city.City;
import id.co.telkomsigma.tmf.data.model.master.village.Village;

import javax.persistence.*;
import java.util.Set;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TMFConstant.Table.Master.MST_DISTRICT, schema = "bill")
public class District extends AAuditTrail {

    /**
     *
     *
     */
    private static final long serialVersionUID = -6165282598525095185L;

    @JsonManagedReference
    private Set<Village> villages;

    @JsonBackReference
    private City city;

    @OneToMany(mappedBy = "district", fetch = FetchType.LAZY)
    public Set<Village> getVillages() {
        return villages;
    }

    public void setVillages(Set<Village> villages) {
        this.villages = villages;
    }

    @Override
    public String tableName() {
        return TMFConstant.Table.Master.MST_DISTRICT;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    
}
