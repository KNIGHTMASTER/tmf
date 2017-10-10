package id.co.telkomsigma.tmf.data.model.base;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <KEY>
 */
@MappedSuperclass
public class BaseMapperDATA<KEY extends Serializable> implements IMasterDATA, ISingleKeyDATA<KEY>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -81861420500108351L;
	private KEY id;
	private String code;
	private String name;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	@Override
	public KEY getId() {
		return id;
	}
	
	@Size(max = 50)
	@Column(name = "code", length = 50, unique = true)	
	@Override
	public String getCode() {
		return code;
	}

	@Size(max = 100)
	@Column(name = "name", length = 100)
	@Override
	public String getName() {
		return name;
	}

	public void setId(KEY id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "IBaseMapperDATA [id=" + id + ", code=" + code + ", name="
				+ name + "]";
	}

	
}
