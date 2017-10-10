package id.co.telkomsigma.tmf.integration.messaging.impl;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.request.MailContentRequestDTO;
import id.co.telkomsigma.tmf.integration.messaging.IJMSProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class MailProducer implements IJMSProducer<MailContentRequestDTO> {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired(required = false)
    @Qualifier(value = TMFConstant.JMS.Queue.QUEUE_MAIL)
    Queue queueMail;

    @Override
    public void send(MailContentRequestDTO p_Message) {
        this.jmsMessagingTemplate.convertAndSend(queueMail, p_Message);
    }
}
