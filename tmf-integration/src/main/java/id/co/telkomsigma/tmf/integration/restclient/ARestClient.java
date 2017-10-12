package id.co.telkomsigma.tmf.integration.restclient;

import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * created on 11/15/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <REQUEST_ENTITY>
 */
public abstract class ARestClient<DATA, REQUEST_ENTITY> implements IRestClient<DATA, REQUEST_ENTITY> {

    protected String urlTarget;

    @Override
    public DATA queryClient(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(urlTarget, getObjectResultClass());
    }

    @Override
    public DATA consume() {
        return null;
    }

    @Override
    public DATA queryClient(MultiValueMap<String, String> p_HttpHeaders, REQUEST_ENTITY p_ObjectToPass) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpEntity<REQUEST_ENTITY> entity = new HttpEntity(p_ObjectToPass, p_HttpHeaders);
        return restTemplate.postForObject(urlTarget, entity, getObjectResultClass());
    }

    public abstract Class<DATA> getObjectResultClass();

    @Override
    public String getParam() {
        return urlTarget;
    }

    @Override
    public void setParam(String p_Param) {
        this.urlTarget = p_Param;
    }
}
