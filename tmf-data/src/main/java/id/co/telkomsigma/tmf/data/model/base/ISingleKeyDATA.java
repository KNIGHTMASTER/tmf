package id.co.telkomsigma.tmf.data.model.base;

import java.io.Serializable;

/**
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <KEY>
 */
public interface ISingleKeyDATA<KEY extends Serializable> {
	
	public KEY getId();

}
