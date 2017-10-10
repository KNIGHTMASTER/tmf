package id.co.telkomsigma.tmf.integration.config;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import javax.jms.Queue;
import java.util.ArrayList;
import java.util.List;

import static id.co.telkomsigma.tmf.data.constant.TMFConstant.JMS.TrustedPackages.*;

/**
 * Created on 9/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Configuration
@EnableJms
@Order(6)
public class JMSConfig implements JmsListenerConfigurer {

    @Value("${spring.jmx.enabled}")
    boolean jmxEnabled;

    @Value("${spring.activemq.broker-url}")
    String activeMQBrokerUrl;

    @Value("${jms.listener.concurrency.size}")
    String jmsListenerConcurrencySize;

    @Bean(name = TMFConstant.JMS.Queue.QUEUE_MAIL)
    public Queue queueMail() {
        return new ActiveMQQueue(TMFConstant.JMS.Queue.QUEUE_MAIL);
    }

    @Bean
    public DefaultMessageHandlerMethodFactory handlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(messageConverter());
        return factory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory basicConnectionFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConcurrency(jmsListenerConcurrencySize);
        factory.setAutoStartup(false);
        factory.setConnectionFactory(activeMQConnectionFactory());
        return factory;
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(activeMQBrokerUrl);
        List<String> trustedPackages = new ArrayList<>();
        trustedPackages.add(JAVA_LANG);
        trustedPackages.add(JAVA_MATH);
        trustedPackages.add(JAVA_UTIL);
        trustedPackages.add(TMFConstant.Common.BASE_PACKAGES);
        factory.setTrustedPackages(trustedPackages);
        return factory;
    }

    @Bean
    public MessageConverter messageConverter() {
        return new MappingJackson2MessageConverter();
    }

    @Override
    public void configureJmsListeners(JmsListenerEndpointRegistrar jmsListenerEndpointRegistrar) {
            jmsListenerEndpointRegistrar.setMessageHandlerMethodFactory(handlerMethodFactory());
    }
}
