package id.co.telkomsigma.tmf.data.model.master.village;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;
import id.co.telkomsigma.tmf.data.model.master.district.District;

import javax.persistence.*;

/**
 * created on 1/9/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TMFConstant.Table.Master.MST_VILLAGE)
public class Village extends AAuditTrail {
    private static final long serialVersionUID = -882333480264178395L;

    @Override
    public String tableName() {
        return TMFConstant.Table.Master.MST_VILLAGE;
    }

    private District district;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "district_id")
    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Village{" +
                "district=" + district +
                '}';
    }
}
