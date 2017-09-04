package id.co.telkomsigma.tmf.data.model.base;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@MappedSuperclass
public abstract class AAuditTrail extends ABaseAuditTrail {

	private SigmaAuditorAware sigmaAuditorAware;
	
	public AAuditTrail() {
		sigmaAuditorAware = new SigmaAuditorAware();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5401587542468260575L;

	@Version
	private Long version;

	/**
	 * Before persist data into Database
	 */
	@PrePersist
	public void onPrePersist(){
		setCreatedBy(sigmaAuditorAware.getCurrentAuditor().getUserName());
		setStatus(TMFConstant.Common.GeneralValue.ONE);
		setCreatedOn(new Date());
		setCreatedIP(sigmaAuditorAware.getCurrentAuditor().getIpAddress());
		setCreatedPlatform(sigmaAuditorAware.getCurrentAuditor().getPlatform());
	}

	/**
	 * Before update data into db
	 */
	@PreUpdate
	public void onPreUpdate(){
		setModifiedOn(new Date());
		setModifiedBy(sigmaAuditorAware.getCurrentAuditor().getUserName());
		setModifiedIP(sigmaAuditorAware.getCurrentAuditor().getIpAddress());
		setModifiedPlatform(sigmaAuditorAware.getCurrentAuditor().getPlatform());
	}

	@Column(name="status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name="remarks", length=255)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name="created_by", length=150)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	@Column(name="created_ip", length=150)
	public String getCreatedIP() {
		return createdIP;
	}

	public void setCreatedIP(String createdIP) {
		this.createdIP = createdIP;
	}

	@Column(name="created_on")
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name="modified_on")
	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Column(name="created_platform")
	public String getCreatedPlatform() {
		return createdPlatform;
	}

	public void setCreatedPlatform(String createdPlatform) {
		this.createdPlatform = createdPlatform;
	}

	@Column(name="modified_by", length=150)
	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Column(name="modified_ip", length=150)
	public String getModifiedIP() {
		return modifiedIP;
	}

	public void setModifiedIP(String modifiedIP) {
		this.modifiedIP = modifiedIP;
	}

	@Column(name="modified_platform")
	public String getModifiedPlatform() {
		return modifiedPlatform;
	}

	public void setModifiedPlatform(String modifiedPlatform) {
		this.modifiedPlatform = modifiedPlatform;
	}
	
}
