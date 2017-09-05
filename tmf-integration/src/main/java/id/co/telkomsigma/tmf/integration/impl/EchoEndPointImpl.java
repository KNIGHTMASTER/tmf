package id.co.telkomsigma.tmf.integration.impl;

import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.integration.IEchoEndPoint;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 9/4/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class EchoEndPointImpl implements IEchoEndPoint {

    @Override
    public ResponseData echo() {
        return new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg());
    }
}
