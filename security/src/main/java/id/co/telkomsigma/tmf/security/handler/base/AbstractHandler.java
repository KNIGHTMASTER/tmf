package id.co.telkomsigma.tmf.security.handler.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public abstract class AbstractHandler {
	
	public void handle(HttpServletResponse response) throws IOException{
		ResponseData responseData = new ResponseData();
		responseData.setResponseCode(getResponseCode().getResponseCode());
		responseData.setResponseMsg(getResponseCode().getResponseMsg());
		ObjectMapper mapperJson = new ObjectMapper();
		PrintWriter writer = response.getWriter();
		writer.println(mapperJson.writeValueAsString(responseData));
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(getResponseCode().getHttpResponse());
	}
	
	public abstract EResponseCode getResponseCode();

}
