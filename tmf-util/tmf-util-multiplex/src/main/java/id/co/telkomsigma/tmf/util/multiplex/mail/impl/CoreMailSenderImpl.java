package id.co.telkomsigma.tmf.util.multiplex.mail.impl;

import id.co.telkomsigma.tmf.util.multiplex.mail.ICoreMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class CoreMailSenderImpl implements ICoreMailSender {

	@Autowired
	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendMailContent(String from, String to, String subject, String content) {
		MimeMessage message = mailSender.createMimeMessage();
		buildBasicMimeMessageHelper(message, from, to, subject, content);
		mailSender.send(message);
	}

	@Override
	public void sendMailWithAttachment(String p_From, String p_To, String p_Subject, String p_TextContent, File p_Attachment, String p_AttachmentName) {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			InternetAddress addressFrom = new InternetAddress(p_From, "gmail.com");
			helper.setFrom(addressFrom);
			helper.setTo(p_To);
			helper.setSubject(p_Subject);
			helper.setText(p_TextContent, true);
			helper.setPriority(1);
			FileSystemResource file = new FileSystemResource(p_Attachment);
			helper.addAttachment(p_AttachmentName, file);
		} catch (MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		mailSender.send(message);	
	}

	@Override
	public void sendMailWithAttachmentAndInlineResource(String p_From, String p_To, String p_Subject, String p_TextContent, File p_Attachment,
			String p_AttachmentName, String p_InlineResource) {
		// TODO Auto-generated method stub
		
	}
	
	private MimeMessageHelper buildBasicMimeMessageHelper(MimeMessage mimeMessage, String from, String to, String subject, String content){
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		try {
			InternetAddress addressFrom = new InternetAddress(from, "gmail.com");
			helper.setFrom(addressFrom);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);
			helper.setPriority(1);
		} catch (MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return helper;
	}

}
