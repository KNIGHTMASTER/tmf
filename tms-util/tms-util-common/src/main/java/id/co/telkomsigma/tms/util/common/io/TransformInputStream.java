package id.co.telkomsigma.tms.util.common.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class TransformInputStream {
	
	/**
	 * @param in
	 * @return
	 */
	public static ByteArrayOutputStream toByteArray(InputStream in){
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			CommonIOUtils.copy(in, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}
	
}
