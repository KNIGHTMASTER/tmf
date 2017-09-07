package id.co.telkomsigma.tmf.integration.messaging;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.dto.request.MailContentRequestDTO;
import id.co.telkomsigma.tmf.util.multiplex.mail.ICoreMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class MailConsumer implements IJMSConsumer<MailContentRequestDTO>{

    @Autowired
    ICoreMailSender mailSender;

    @JmsListener(destination = TMFConstant.Queue.QUEUE_HEADER)
    @Override
    public void receive(MailContentRequestDTO p_Message) {
        System.out.println("Message "+p_Message.getSubject());
        mailSender.sendMailContent(p_Message.getFrom(), p_Message.getTo(), p_Message.getSubject(), p_Message.getContent());
    }

}
