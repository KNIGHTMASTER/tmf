package id.co.telkomsigma.tmf.integration.restclient;

import org.springframework.util.MultiValueMap;

/**
 * created on 11/15/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <DATA>
 * @param <REQUEST_ENTITY>
 */
public interface IRestClient<DATA, REQUEST_ENTITY> {

    DATA consume();

    DATA queryClient(String p_UrlToQuery);

    DATA queryClient(String p_UrlToQuery, MultiValueMap<String, String> p_HttpHeaders, REQUEST_ENTITY p_ObjectToPass);
}
