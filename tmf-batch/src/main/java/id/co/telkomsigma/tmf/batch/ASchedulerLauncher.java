package id.co.telkomsigma.tmf.batch;

import org.springframework.batch.core.JobParameters;

/**
 * Created on 10/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class ASchedulerLauncher implements ISchedulerLauncher {

    @Override
    public JobParameters createJobParameters(Object p_JOB_PARAM) {
        return null;
    }
}
