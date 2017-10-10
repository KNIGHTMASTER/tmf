package id.co.telkomsigma.tmf.util.common.time;

import java.text.SimpleDateFormat;

/**
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FormatDateConstant {

	private static final String patternDefault = "dd-MM-yyyy HH:mm:ss.S";
	private static final String patternDefault2 = "yyyy-MM-dd HH:mm:ss";
	private static final String patternDefault3 = "yyyyMMdd";
	private static final String patternISO8601 = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";	
	private static final String patternDateOfBirth = "yyyy-MM-dd";
	
	public static SimpleDateFormat DEFAULT = new SimpleDateFormat(patternDefault);
	public static SimpleDateFormat DEFAULT2 = new SimpleDateFormat(patternDefault2);
	public static SimpleDateFormat DEFAULT3 = new SimpleDateFormat(patternDefault3);
	public static SimpleDateFormat ISO8601 = new SimpleDateFormat(patternISO8601);
	public static SimpleDateFormat DATE_OF_BIRTH = new SimpleDateFormat(patternDateOfBirth);
	
}
