package id.co.telkomsigma.tmf.service;

import id.co.telkomsigma.tmf.data.dto.response.AdminMenuDTO;

import java.util.List;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IAdminMenuGenerator {

    List<AdminMenuDTO> generateAdminMenu(String p_UserName);
}
