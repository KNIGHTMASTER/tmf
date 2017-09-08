package id.co.telkomsigma.tmf.integration.messaging.impl;

import id.co.telkomsigma.tmf.integration.messaging.IJMSListenerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.config.JmsListenerEndpointRegistry;
import org.springframework.stereotype.Service;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class JMSListenerManagerImpl implements IJMSListenerManager {

    @Autowired
    private JmsListenerEndpointRegistry jmsListenerEndpointRegistry;

    private static final Logger LOGGER = LoggerFactory.getLogger(JMSListenerManagerImpl.class);

    @Override
    public void stopListener() {
        for (String string : jmsListenerEndpointRegistry.getListenerContainerIds()){
            jmsListenerEndpointRegistry.getListenerContainer(string).stop();
        }
        LOGGER.info("JMS Message Listeners has been stopped");
    }

    @Override
    public void startListener() {
        for (String string : jmsListenerEndpointRegistry.getListenerContainerIds()){
            this.jmsListenerEndpointRegistry.getListenerContainer(string).start();
        }
        LOGGER.info("JMS Message Listeners has been established");
    }
}
