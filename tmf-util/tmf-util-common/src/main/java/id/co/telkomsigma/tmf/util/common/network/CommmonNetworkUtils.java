package id.co.telkomsigma.tmf.util.common.network;

import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CommmonNetworkUtils {

    public static String getHostIp() {
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            return socket.getLocalAddress().getHostAddress();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
