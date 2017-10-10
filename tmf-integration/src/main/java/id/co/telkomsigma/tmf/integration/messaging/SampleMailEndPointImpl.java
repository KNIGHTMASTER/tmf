package id.co.telkomsigma.tmf.integration.messaging;

import id.co.telkomsigma.tmf.data.constant.EResponseCode;
import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.request.MailContentRequestDTO;
import id.co.telkomsigma.tmf.integration.messaging.impl.MailProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class SampleMailEndPointImpl implements ISampleMailEndPoint {

    @Autowired
    MailProducer mailProducer;

    @Override
    public ResponseData sendMail() {
        MailContentRequestDTO mailContentRequestDTO = new MailContentRequestDTO();
        mailContentRequestDTO.setFrom("antikepet@gmail.com");
        mailContentRequestDTO.setTo("jejezisal@gmail.com");
        mailContentRequestDTO.setSubject("Sample Mail From JMS");
        mailContentRequestDTO.setContent("Hello World");

        ResponseData responseData = new ResponseData(EResponseCode.RC_SUCCESS.getResponseCode(), EResponseCode.RC_SUCCESS.getResponseMsg());
        try{
            mailProducer.send(mailContentRequestDTO);
        }catch (Exception e){
            responseData = new ResponseData(EResponseCode.RC_FAILURE.getResponseCode(), EResponseCode.RC_FAILURE.getResponseMsg());
        }
        return responseData;
    }
}
