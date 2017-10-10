package id.co.telkomsigma.tmf.data.model.security;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.base.AAuditTrail;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = TMFConstant.Table.Security.SEC_FUNCTION, schema = "bill")
public class SecurityFunction extends AAuditTrail {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8448733606113677512L;

	@Override
	public String tableName() {
		return TMFConstant.Table.Security.SEC_FUNCTION;
	}

	private String url;
	private Integer order;
	private Integer level;
	private String style;

	@JsonBackReference
	private SecurityFunction parentFunction;

	@JsonManagedReference
	private List<SecurityFunction> functions = new ArrayList<>();
	/*@OneToMany
	@JoinTable(
            name = "sec_function",
            joinColumns = {@JoinColumn(name = "parent_id")},
            inverseJoinColumns = {@JoinColumn(name = "id")}
    )*/
	


	@Column(name = "url", length = 150)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "order")
	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	@Column(name = "level")
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "style", length = 150)
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@ManyToOne
	@JoinColumn(name = "parent_id")
	public SecurityFunction getParentFunction() {
		return parentFunction;
	}

	public void setParentFunction(SecurityFunction parentFunction) {
		this.parentFunction = parentFunction;
	}

	@OneToMany(mappedBy = "parentFunction")
	public List<SecurityFunction> getFunctions() {
		return functions;
	}

	public void setFunctions(List<SecurityFunction> functions) {
		this.functions = functions;
	}

	@Override
	public String toString() {
		return "SecurityFunction "+super.toString()+"[url=" + url + ", order=" + order + ", level=" + level + ", style=" + style
				+ ", parentFunction=" + parentFunction + ", functions=" + functions + "]";
	}
	
	
}
