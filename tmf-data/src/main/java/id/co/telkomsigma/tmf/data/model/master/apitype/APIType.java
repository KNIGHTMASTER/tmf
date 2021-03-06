package id.co.telkomsigma.tmf.data.model.master.apitype;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Entity
@Table(name = TMFConstant.Table.Master.MST_API_TYPE, schema = "bill")
@ApiModel("Model API Type")
public class APIType extends AAuditTrail {

    /**
     *
     */
    private static final long serialVersionUID = -6244317712417803145L;

    private String apiTypeIdentifier;
    private String apiTypeSecret;
    private String apiTypeHost;
    private String apiTypePort;
    private String apiTypeProtocol;
    private String apiTypeRedirect;
    private String apiTypeExpired;   

    @ApiModelProperty(value = "Api Type Identifier", required = true)
    @Column(name = "api_type_identifier", unique = true, length = 150)
    @NotNull
    public String getApiTypeIdentifier() {
        return apiTypeIdentifier;
    }

    public void setApiTypeIdentifier(String apiTypeIdentifier) {
        this.apiTypeIdentifier = apiTypeIdentifier;
    }

    @ApiModelProperty(value = "Api Type Secret or Credential", required = true)
    @Column(name = "api_type_secret", unique = true, length = 150)
    @NotNull
    public String getApiTypeSecret() {
        return apiTypeSecret;
    }

    public void setApiTypeSecret(String apiTypeSecret) {
        this.apiTypeSecret = apiTypeSecret;
    }

    @ApiModelProperty(value = "Api Type Host", required = true)
    @Column(name = "api_type_host", unique = true, length = 150)
    @NotNull
    public String getApiTypeHost() {
        return apiTypeHost;
    }

    public void setApiTypeHost(String apiTypeHost) {
        this.apiTypeHost = apiTypeHost;
    }

    @ApiModelProperty(value = "Api Type Port", required = true)
    @Column(name = "api_type_port", unique = true, length = 150)
    @NotNull
    public String getApiTypePort() {
        return apiTypePort;
    }

    public void setApiTypePort(String apiTypePort) {
        this.apiTypePort = apiTypePort;
    }

    @ApiModelProperty(value = "Api Type Protocol", required = true)
    @Column(name = "api_type_protocol", unique = true, length = 150)
    @NotNull
    public String getApiTypeProtocol() {
        return apiTypeProtocol;
    }

    public void setApiTypeProtocol(String apiTypeProtocol) {
        this.apiTypeProtocol = apiTypeProtocol;
    }

    @ApiModelProperty(value = "Api Type Redirect", required = true)
    @Column(name = "api_type_redirect", unique = true, length = 150)
    @NotNull
    public String getApiTypeRedirect() {
        return apiTypeRedirect;
    }

    public void setApiTypeRedirect(String apiTypeRedirect) {
        this.apiTypeRedirect = apiTypeRedirect;
    }

    @ApiModelProperty(value = "Api Type Expired", required = true)
    @Column(name = "api_type_expired", unique = true, length = 150)
    @NotNull
    public String getApiTypeExpired() {
        return apiTypeExpired;
    }

    public void setApiTypeExpired(String apiTypeExpired) {
        this.apiTypeExpired = apiTypeExpired;
    }

    @Override
    public String tableName() {
        return TMFConstant.Table.Master.MST_API_TYPE;
    }

}
