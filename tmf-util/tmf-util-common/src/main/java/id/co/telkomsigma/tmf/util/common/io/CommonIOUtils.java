package id.co.telkomsigma.tmf.util.common.io;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <b>Common IO Utils:</b></br>
 * &emsp;&emsp;&emsp;Reference = org.apache.commons.io.IOUtils</br>
 * 
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CommonIOUtils {

	private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;
	private static final int EOF = -1;

	/**
	 * @param input
	 * @param output
	 * @return
	 * @throws java.io.IOException
	 */
	public static int copy(InputStream input, OutputStream output) throws IOException {
		long count = copyLarge(input, output);
		if (count > Integer.MAX_VALUE) {
			return -1;
		}
		return (int) count;
	}

	/**
	 * @param input
	 * @param output
	 * @return
	 * @throws java.io.IOException
	 */
	public static long copyLarge(InputStream input, OutputStream output) throws IOException {
		return copyLarge(input, output, new byte[DEFAULT_BUFFER_SIZE]);
	}

	/**
	 * @param input
	 * @param output
	 * @param buffer
	 * @return
	 * @throws java.io.IOException
	 */
	public static long copyLarge(InputStream input, OutputStream output, byte[] buffer) throws IOException {
		long count = 0;
		int n = 0;
		while (EOF != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
			count += n;
		}
		return count;
	}

	public static String read(String p_FileName) {
		BufferedReader br = null;
		String everything = "";
		try {
			br = new BufferedReader(new FileReader(p_FileName));
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    everything = sb.toString();
		}catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
		    try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return everything;
	}
	
	public static byte[] readRaw(String p_FileName){
		try{
			FileInputStream keyFis = new FileInputStream(p_FileName);
		    byte[] encKey = new byte[keyFis.available()];
		    keyFis.read(encKey);
		    keyFis.close();
		    return encKey;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}	    
	}
	
	private static byte[] intToByteArray ( final int i ) throws IOException {      
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    DataOutputStream dos = new DataOutputStream(bos);
	    dos.writeInt(i);
	    dos.flush();
	    return bos.toByteArray();
	}

	public static void write(String p_FileName, byte[] p_TextToWrite) {
		try {
			FileOutputStream fs = new FileOutputStream(p_FileName);
			fs.write(p_TextToWrite);
                        fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeKey(String p_FileName, byte[] p_KeyToFlush) {
		try {
			FileOutputStream keyfos = new FileOutputStream(p_FileName);
			keyfos.write(p_KeyToFlush);
			keyfos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void overwrite(String p_FileName, String p_TextToWrite) {
		File fold = new File(p_FileName);
		fold.delete();		
		File fnew = new File(p_FileName);
		try {
			FileWriter f2 = new FileWriter(fnew, false);
			f2.write(p_TextToWrite);
			f2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
        
        public static double getFileSize(String p_FilePath){
            if (p_FilePath != null){
                File file = new File(p_FilePath);
                return file.length();
            }else{
                return 0.0;
            }
        }        
}
