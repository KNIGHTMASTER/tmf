package id.co.telkomsigma.tmf.integration.restclient;

import id.co.telkomsigma.tmf.data.param.IComponentInitializer;
import id.co.telkomsigma.tmf.data.param.IParameterizedComponent;
import org.springframework.util.MultiValueMap;

/**
 * created on 11/15/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <REQUEST_ENTITY>
 */
public interface IRestClient<DATA, REQUEST_ENTITY> extends IParameterizedComponent<String>, IComponentInitializer{

    DATA consume();

    DATA queryClient();

    DATA queryClient(MultiValueMap<String, String> p_HttpHeaders, REQUEST_ENTITY p_ObjectToPass);
}
