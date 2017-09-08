package id.co.telkomsigma.tmf.integration.messaging.impl;

import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.integration.messaging.IJMSListenerEndPoint;
import id.co.telkomsigma.tmf.integration.messaging.IJMSListenerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class JMSListenerEndPointImpl implements IJMSListenerEndPoint {

    @Autowired
    IJMSListenerManager listenerManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(JMSListenerEndPointImpl.class);

    @Override
    public ResponseData start() {
        ResponseData responseData = new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg());
        try {
            listenerManager.startListener();
        } catch (Exception e){
            LOGGER.error(e.toString());
            responseData = new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg());
        }
        return responseData;
    }

    @Override
    public ResponseData stop() {
        ResponseData responseData = new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg());
        try {
            listenerManager.stopListener();
        } catch (Exception e){
            LOGGER.error(e.toString());
            responseData = new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg());
        }
        return responseData;
    }
}
