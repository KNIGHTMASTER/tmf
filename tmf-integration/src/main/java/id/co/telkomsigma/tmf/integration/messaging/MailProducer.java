package id.co.telkomsigma.tmf.integration.messaging;

import id.co.telkomsigma.tmf.data.dto.request.MailContentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class MailProducer implements IJMSProducer<MailContentRequestDTO>{

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    Queue queue;

    @Override
    public void send(MailContentRequestDTO p_Message) {
        this.jmsMessagingTemplate.convertAndSend(queue, p_Message);
    }
}
