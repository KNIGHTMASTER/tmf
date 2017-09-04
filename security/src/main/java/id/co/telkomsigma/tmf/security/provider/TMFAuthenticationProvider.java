package id.co.telkomsigma.tmf.security.provider;


import id.co.telkomsigma.tmf.data.dto.TMFAuthenticationDetailDTO;
import id.co.telkomsigma.tmf.data.model.base.TMFAuthenticationDetail;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class TMFAuthenticationProvider {

	private String userName;
	private String ipAddress;
	private String platform;

	public TMFAuthenticationDetailDTO generateAuth(){
		TMFAuthenticationDetail ethAuthenticationDetail = (TMFAuthenticationDetail) SecurityContextHolder.getContext().getAuthentication().getDetails();
		TMFAuthenticationDetailDTO ethAuthenticationDetailDTO = ethAuthenticationDetail.getTMFAuthenticationDetailDTO();
		userName = ethAuthenticationDetail.getTMFAuthenticationDetailDTO().getUserName();
		ipAddress = ethAuthenticationDetail.getTMFAuthenticationDetailDTO().getIpAddress();
		platform = ethAuthenticationDetail.getTMFAuthenticationDetailDTO().getPlatform();
		return ethAuthenticationDetailDTO;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
}
