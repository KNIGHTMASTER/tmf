package id.co.telkomsigma.tmf.security.api;

import id.co.telkomsigma.tmf.data.dto.ResponseData;
import id.co.telkomsigma.tmf.data.dto.request.AuthTokenDataRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 9/2/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Api(value = "API Authentication", description = "Rest Web Service Authenticating Users")
@RequestMapping("/auth")
public interface IAuthenticationTokenEndPoint {

    @PostMapping("/login")
    @ApiOperation(value = "Auth", notes = "Authenticating Users",  response = ResponseData.class)
    ResponseEntity<?> auth(@RequestBody AuthTokenDataRequest authTokenDataRequest);

    @GetMapping("/refresh")
    ResponseEntity<?> refresh();
}
