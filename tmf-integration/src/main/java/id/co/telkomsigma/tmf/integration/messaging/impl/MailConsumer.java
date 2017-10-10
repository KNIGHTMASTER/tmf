package id.co.telkomsigma.tmf.integration.messaging.impl;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.constant.TMFConstant.JMS.ConnectionFactory;
import id.co.telkomsigma.tmf.data.dto.request.MailContentRequestDTO;
import id.co.telkomsigma.tmf.integration.messaging.IJMSConsumer;
import id.co.telkomsigma.tmf.util.multiplex.mail.ICoreMailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Component
public class MailConsumer implements IJMSConsumer<MailContentRequestDTO> {

    @Autowired
    ICoreMailSender mailSender;

    private static final Logger LOGGER = LoggerFactory.getLogger(MailConsumer.class);

    @JmsListener(containerFactory = ConnectionFactory.BASIC_CONNECTION_FACTORY, destination = TMFConstant.JMS.Queue.QUEUE_MAIL)
    @Override
    public void receive(MailContentRequestDTO p_Message) {
        LOGGER.info(p_Message.getContent());
        mailSender.sendMailContent(p_Message.getFrom(), p_Message.getTo(), p_Message.getSubject(), p_Message.getContent());
    }

}
