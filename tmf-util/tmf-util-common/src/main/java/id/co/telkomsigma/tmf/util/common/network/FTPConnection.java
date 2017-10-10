package id.co.telkomsigma.tmf.util.common.network;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FTPConnection {

    private static final Logger LOGGER = LoggerFactory.getLogger(FTPConnection.class);

    private FTPClient fTPClient;

    public FTPConnection(FTPClient p_FTPClient) {
        this.fTPClient = p_FTPClient;
    }

    ParamFTPServer paramFTPConnection;

    public FTPClient getfTPClient() {
        return fTPClient;
    }

    public void setfTPClient(FTPClient fTPClient) {
        this.fTPClient = fTPClient;
    }

    public int isConnected() {
        int result = 0;
        String ipServer = paramFTPConnection.getIpServer();
        int ftpPort = Integer.valueOf(paramFTPConnection.getFtpPort());
        String ftpUserName = paramFTPConnection.getFtpUserName();
        String ftpPassword = paramFTPConnection.getFtpPassword();
        LOGGER.info(paramFTPConnection.toString());

        try {
            fTPClient.connect(ipServer, ftpPort);
            fTPClient.setConnectTimeout(5000);//5 seconds
            getServerReply(fTPClient);
            int replyCode = fTPClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                LOGGER.info("Operation failed. Server reply code: " + replyCode);
            }
            boolean success = fTPClient.login(ftpUserName, ftpPassword);
            getServerReply(fTPClient);
            if (!success) {
                LOGGER.info("Could not login to the FTP server");
            } else {
                result = 1;
                LOGGER.info("Logged in FTP server");
            }
        } catch (IOException ex) {
            LOGGER.error("Error Checking FTP Connection "+ex.toString());
        }
        return result;
    }

    private String getServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        String result = "";
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                result = result.concat(" ").concat(aReply);
            }
        }
        return result;
    }

    public void upload(String p_OriginFileName, String p_LocalFilePath, String p_RemoteFilePath) {
        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(paramFTPConnection.getIpServer(), Integer.parseInt(paramFTPConnection.getFtpPort()));
            ftpClient.login(paramFTPConnection.getFtpUserName(), paramFTPConnection.getFtpPassword());
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            InputStream inputStream = new FileInputStream(p_LocalFilePath);

            LOGGER.info("Start uploading file ".concat(p_LocalFilePath));
            boolean done = ftpClient.storeFile(p_RemoteFilePath, inputStream);
            inputStream.close();
            if (done) {
                LOGGER.info("The file "+p_RemoteFilePath+" has been uploaded successfully.");
            }
        } catch (IOException ex) {
            LOGGER.error("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    public int download(String p_RemoteFilePath, String p_LocalFilePath) {
        int result = 0;
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(paramFTPConnection.getIpServer(), Integer.parseInt(paramFTPConnection.getFtpPort()));
            if (Boolean.valueOf(paramFTPConnection.getFtpPassiveMode())){
                ftpClient.enterLocalPassiveMode();
            }
            ftpClient.login(paramFTPConnection.getFtpUserName(), paramFTPConnection.getFtpPassword());
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(p_LocalFilePath));
            boolean success = ftpClient.retrieveFile(p_RemoteFilePath, outputStream);
            outputStream.close();

            if (success) {
                result = 1;
                LOGGER.info("File "+p_RemoteFilePath+" has been downloaded successfully.");
            }else{
                LOGGER.info("Failed to download File "+p_RemoteFilePath+" From FTP");
            }
        } catch (Exception ex) {
            LOGGER.error("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public int delete(String p_RemoteFilePath) {
        FTPClient ftpClient = new FTPClient();
        int result = 0;
        try {
            ftpClient.connect(paramFTPConnection.getIpServer(), Integer.parseInt(paramFTPConnection.getFtpPort()));
            ftpClient.login(paramFTPConnection.getFtpUserName(), paramFTPConnection.getFtpPassword());
            try {
                boolean deleted = ftpClient.deleteFile(p_RemoteFilePath);
                if (deleted) {
                    result = 1;
                    LOGGER.info("The file "+p_RemoteFilePath+ "was deleted successfully.");
                } else {
                    LOGGER.warn("Could not delete the file.");
                }
            } catch (IOException ex) {
                LOGGER.error("Delete FTP File Error " + ex.getMessage());
            }
        } catch (IOException e) {
            LOGGER.error("Error : " + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    public List<String> getAllRemoteFiles(String p_RemoteDirectory) {
        FTPClient ftpClient = new FTPClient();
        List<String> remoteFTPFiles = new ArrayList<>();
        try {
            ftpClient.connect(paramFTPConnection.getIpServer(), Integer.parseInt(paramFTPConnection.getFtpPort()));
            if (Boolean.valueOf(paramFTPConnection.getFtpPassiveMode())){
                ftpClient.enterLocalPassiveMode();
            }
            ftpClient.login(paramFTPConnection.getFtpUserName(), paramFTPConnection.getFtpPassword());
            FTPFile[] files = ftpClient.listFiles(p_RemoteDirectory);
            if (files.length > 0){
                for (FTPFile file : files) {
                    String details = file.getName();
                    if (file.isDirectory()) {
                        details = "[" + details + "]";
                    }else {
                        remoteFTPFiles.add(file.getName());
                    }
                    details += "\t\t" + file.getSize() + " KB";
                    LOGGER.debug(details);
                }
            }else {
                LOGGER.debug("No New File Found on FTP Server Directory ".concat(p_RemoteDirectory));
            }
        } catch (Exception e) {
            LOGGER.error("Error Get All Remote Files : " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()){
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return remoteFTPFiles;
    }

}
