package id.co.telkomsigma.tmf.smi;

import id.co.telkomsigma.tmf.data.constant.TMFConstant;
import id.co.telkomsigma.tmf.data.model.security.SecurityCompany;
import id.co.telkomsigma.tmf.integration.scaffolding.IScaffoldingEndPoint;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Api(value = "API Security Company", description = "Rest Scaffolding Security Company")
@RequestMapping(TMFConstant.PathName.Security.PATH_COMPANY)
public interface ISecurityCompanyEndPoint extends IScaffoldingEndPoint<SecurityCompany> {
}
