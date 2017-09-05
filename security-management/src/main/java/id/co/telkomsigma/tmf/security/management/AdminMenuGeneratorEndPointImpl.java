package id.co.telkomsigma.tmf.security.management;


import id.co.telkomsigma.tmf.data.dto.response.AdminMenuDTO;
import id.co.telkomsigma.tmf.integration.IAdminMenuGeneratorEndPoint;
import id.co.telkomsigma.tmf.security.provider.UserAuthenticationContext;
import id.co.telkomsigma.tmf.service.IAdminMenuGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@RestController
public class AdminMenuGeneratorEndPointImpl implements IAdminMenuGeneratorEndPoint {

    @Autowired
    IAdminMenuGenerator adminMenuGenerator;

    @Override
    public List<AdminMenuDTO> generateMenu() {
        return adminMenuGenerator.generateAdminMenu(UserAuthenticationContext.getInstance().getCurrentUsername());
    }
}
