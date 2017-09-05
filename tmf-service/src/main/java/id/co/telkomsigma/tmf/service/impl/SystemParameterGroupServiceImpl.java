package id.co.telkomsigma.tmf.service.impl;

import id.co.telkomsigma.tmf.dao.ISystemParameterGroupDAO;
import id.co.telkomsigma.tmf.data.model.system.SystemParameterGroup;
import id.co.telkomsigma.tmf.service.ISystemParameterGroupService;
import id.co.telkomsigma.tmf.service.scaffolding.impl.AScaffoldingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created on 9/5/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class SystemParameterGroupServiceImpl extends AScaffoldingService<SystemParameterGroup> implements ISystemParameterGroupService {

    @Autowired
    ISystemParameterGroupDAO systemParameterGroupDAO;

    @PostConstruct
    @Override
    public void init() {
        scaffoldingDAO = systemParameterGroupDAO;
    }
}
