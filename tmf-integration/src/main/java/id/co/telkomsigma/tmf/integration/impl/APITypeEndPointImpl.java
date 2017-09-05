package id.co.telkomsigma.tmf.integration.impl;

import id.co.telkomsigma.tmf.data.model.master.apitype.APIType;
import id.co.telkomsigma.tmf.integration.IAPITypeEndPoint;
import id.co.telkomsigma.tmf.integration.scaffolding.impl.AScaffoldingEndPoint;
import id.co.telkomsigma.tmf.service.IApiTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created on 9/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
@Api(value = "API Type Rest", description = "Rest Web Service for Entity API Type")
@RequestMapping("/api/apitype")
public class APITypeEndPointImpl extends AScaffoldingEndPoint<APIType> implements IAPITypeEndPoint {

    @Autowired
    IApiTypeService apiTypeService;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingService = apiTypeService;
    }

}
