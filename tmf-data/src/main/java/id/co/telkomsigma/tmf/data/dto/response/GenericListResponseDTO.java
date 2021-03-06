package id.co.telkomsigma.tmf.data.dto.response;

import id.co.telkomsigma.tmf.data.dto.ResponseData;

import java.io.Serializable;
import java.util.List;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DTO>
 */
public class GenericListResponseDTO<DTO> implements Serializable{
    /**
     * 
     *     
     */
    private static final long serialVersionUID = -4899165119417997624L;
        
    private List<DTO> content;
    private ResponseData responseData;

    public List<DTO> getContent() {
        return content;
    }

    public void setContent(List<DTO> content) {
        this.content = content;
    }

    public ResponseData getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    @Override
    public String toString() {
        return "GenericResponseDTO{" + "content=" + expandResponse(content) + ", responseData=" + responseData.toString() + '}';
    }
    
    String expandResponse(List<DTO> dtoList){
        String result = "";
        for (DTO dto : dtoList){
            result += dto.toString();
        }
        return result;
    }
}
