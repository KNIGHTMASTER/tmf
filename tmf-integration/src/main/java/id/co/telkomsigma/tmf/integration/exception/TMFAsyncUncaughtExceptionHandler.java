package id.co.telkomsigma.tmf.integration.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * Created on 6/8/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class TMFAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TMFAsyncUncaughtExceptionHandler.class);

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        LOGGER.error("Exception message - " + throwable.getMessage());
        LOGGER.error("Method name - " + method.getName());
        for (Object param : objects) {
            LOGGER.error("Parameter value - " + param);
        }
    }
}
