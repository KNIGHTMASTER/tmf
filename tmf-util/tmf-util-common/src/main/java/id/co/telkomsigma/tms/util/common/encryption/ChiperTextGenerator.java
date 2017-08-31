package id.co.telkomsigma.tms.util.common.encryption;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;


/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class ChiperTextGenerator {

	public static enum Mode {
	    AES, DES, BLOWFISH, DESEDE, DIFFIEHELLMAN, DSA, OAEP, RC2, DESECBPKCS5PADDING
	}
	
	private static final String AES = "AES";
	private static final String DES = "DES";
	private static final String BLOWFISH = "Blowfish";
	private static final String DESEDE = "DESede";
	private static final String DIFFIEHELLMAN = "DiffieHellman";
	private static final String DSA = "DSA";
	private static final String OAEP = "OAEP";
	private static final String RC2 = "RC2";
	private static final String DESECBPKCS5PADDING = "DES/ECB/PKCS5Padding";
	
	private static final Logger LOGGER = Logger.getLogger(ChiperTextGenerator.class.getName());
	
	public static String getAlgorithm(Mode p_Mode){
		String algorithm = null;
		switch (p_Mode) {
		case AES :
			algorithm = AES;
			break;
		case DES :
			algorithm = DES;
			break;
		case BLOWFISH : 
			algorithm = BLOWFISH;
			break;
		case DESEDE : 
			algorithm = DESEDE;
			break;
		case DIFFIEHELLMAN : 
			algorithm = DIFFIEHELLMAN;
			break;
		case DSA : 
			algorithm = DSA;
			break;
		case OAEP : 
			algorithm = OAEP;
			break;
		case RC2 : 
			algorithm = RC2;
			break;
		case DESECBPKCS5PADDING : 
			algorithm = DESECBPKCS5PADDING;
			break;
		default:
			break;
		}
		return algorithm;
	}
	
	public static Key generateKey(Mode p_Mode){
		KeyGenerator keyGen;
		try {
			keyGen = KeyGenerator.getInstance(getAlgorithm(p_Mode));
			switch (p_Mode) {
			case AES:
				keyGen.init(256);
				break;
			case DES :
				keyGen.init(56);
				break;
			default:
				break;
			}
		    return keyGen.generateKey();
		} catch (NoSuchAlgorithmException e) {			
			e.printStackTrace();
			return null;
		}
	    
	}
	
	public static byte[] encript(Key p_EncriptKey, String p_TextToEncript, Mode p_Mode){
		String algorithm = getAlgorithm(p_Mode);
		
		byte[] result = null;
        try{
        	Cipher cipher = Cipher.getInstance(algorithm);
            
            cipher.init(Cipher.ENCRYPT_MODE, p_EncriptKey);
            result = cipher.doFinal(p_TextToEncript.getBytes());
        }catch (Exception e) {
        	LOGGER.log(Level.SEVERE, "Error encripting using MODE ".concat(algorithm).concat(e.toString()));
		}
		return result;
	}	
	
	public static String decript(Key p_DecriptKey, byte[] p_TextToDecript, Mode p_Mode){
		String algorithm = getAlgorithm(p_Mode);
		String result = null;
		try{
			Cipher cipher = Cipher.getInstance(algorithm);
			
			cipher.init(Cipher.DECRYPT_MODE, p_DecriptKey);
	        result = new String(cipher.doFinal(p_TextToDecript));
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error decription using MODE ".concat(algorithm).concat(e.toString()));
		}
        return result;
	}
}
