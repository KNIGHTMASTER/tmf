package id.co.telkomsigma.tmf.integration;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.master.country.Country;
import id.co.telkomsigma.tmf.integration.scaffolding.IScaffoldingEndPoint;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created on 12/26/2016
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Api(value = "API Type Rest", description = "Rest Web Service for Entity Country")
@RequestMapping(TMFConstant.PathName.Master.PATH_COUNTRY)
public interface ICountryEndPoint extends IScaffoldingEndPoint<Country> {

}
