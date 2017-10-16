package id.co.telkomsigma.tmf.batch;

import org.quartz.StatefulJob;
import org.springframework.batch.core.JobParameters;

/**
 * Created on 10/12/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @param <JOB_PARAM>
 */
public interface ISchedulerLauncher<JOB_PARAM> extends StatefulJob {

    JobParameters createJobParameters(JOB_PARAM p_JOB_PARAM);
}
