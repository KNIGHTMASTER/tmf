package id.co.telkomsigma.tmf.service.impl;

import id.co.telkomsigma.tmf.dao.ApiTypeDAO;
import id.co.telkomsigma.tmf.data.model.master.apitype.APIType;
import id.co.telkomsigma.tmf.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 8/29/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ApiTypeServiceImpl extends AScaffoldingService<APIType> implements IApiTypeService{

    @Autowired
    ApiTypeDAO apiTypeDAO;

    @PostConstruct
    @Override
    public void init() {
        this.scaffoldingDAO = apiTypeDAO;
    }
}
