package id.co.telkomsigma.tms.data.model.base;

import id.co.telkomsigma.tms.data.constant.TmsConstant;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@MappedSuperclass
public abstract class ASyncAuditrail extends AAuditTrail {
    private static final long serialVersionUID = 4850400058779906L;

    private Integer sync;

    @Column(name = "sync")
    public Integer getSync() {
        return sync;
    }

    public void setSync(Integer sync) {
        this.sync = sync;
    }

    /**
     * Before persist into DB, Table with sync column should be assigned @value 0 for Consolidation need
     */
    @PrePersist
    public void onPrePersist(){
    	super.onPrePersist();
    	setSync(TmsConstant.Common.GeneralValue.ZERO);
    }
    
    @Override
    public String toString() {
        return "ASyncAuditrail{" +
                "sync=" + sync +
                '}';
    }
}
