package id.co.telkomsigma.tms.util.multiplex.mail;

import java.io.File;

/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface ICoreMailSender {
	
	void sendMailContent(String from, String to, String subject, String content);

	void sendMailWithAttachment(String p_From, String p_To, String p_Subject, String p_TextContent, File p_Attachment, String p_AttachmentName);
	
	void sendMailWithAttachmentAndInlineResource(String p_From, String p_To, String p_Subject, String p_TextContent, File p_Attachment, String p_AttachmentName, String p_InlineResource);
}
