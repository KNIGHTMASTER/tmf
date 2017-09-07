package id.co.telkomsigma.tmf.integration;

import id.co.telkomsigma.tmf.data.model.master.apitype.APIType;
import id.co.telkomsigma.tmf.integration.scaffolding.IScaffoldingEndPoint;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 9/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Api(value = "API Type Rest", description = "Rest Web Service for Entity API Type")
@RequestMapping("/api/apitype")
public interface IAPITypeEndPoint extends IScaffoldingEndPoint<APIType> {
}
