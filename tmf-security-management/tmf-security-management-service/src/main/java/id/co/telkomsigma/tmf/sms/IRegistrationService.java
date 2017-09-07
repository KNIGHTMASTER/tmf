package id.co.telkomsigma.tmf.sms;

import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.request.RequestMemberActivationDTO;
import id.co.telkomsigma.tmf.data.dto.request.RequestRegistrationMemberDTO;
import id.co.telkomsigma.tmf.data.dto.response.RegistrationMemberResponseDTO;
import id.co.telkomsigma.tmf.service.transaction.ISingleTransaction;
import org.springframework.transaction.annotation.Transactional;

/**
 * created on 1/20/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Transactional
public interface IRegistrationService extends ISingleTransaction<RequestRegistrationMemberDTO> {

    /**
     * <p>Flow Registration</p>
     * <ol>
     *     <li>Input Data</li>
     *     <li>Validating Email</li>
     *     <li>Input to related table on DB with status 0</li>
     *     <li>Send email activation</li>
     *     <li>Update related record with status 1</li>
     * </ol>
     * <p>Result Code</p>
     * <ol>
     *     <li>1 : Success</li>
     *     <li>-1 : Failed</li>
     * </ol>
     * 
     * @return {@link ResponseData}
     */
	@Transactional
    RegistrationMemberResponseDTO registerMember(RequestRegistrationMemberDTO p_RequestRegistrationMemberDTO);
    
    /**
     * <p>Activating member after click link on Email - Set status from user to 1 (Active) </p>    
     * @param p_RequestMemberActivationDto parameter to pass
     * @return {@link ResponseData}
     */
	@Transactional
    ResponseData activateMember(RequestMemberActivationDTO p_RequestMemberActivationDto);

}
