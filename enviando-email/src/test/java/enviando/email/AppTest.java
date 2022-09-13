package enviando.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
	private String userName= "pamelajavieljavatest@gmail.com";
	private String senha = "adljkwvkfislgzxr";
	@Test
	public void testeEmail() {
		
		try{
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.ssl.trust", "*");
		properties.put("mail.smtp.auth", "true"); /*Autorização*/
		properties.put("mail.smtp.starttls", "true");/*Autenticacão*/
		properties.put("mail.smtp.host", "smtp.gmail.com");/*Servidor gmail google*/
		properties.put("mail.smtp.port", "465"); /*Porta do servidor*/
		properties.put("mail.smtp.socketFactory.port", "465"); /*Expecifica qual a porta a ser conectada pelo socket*/
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); /*Classe socket de conexão ao SMTP*/
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName,senha);
			}
		});
		
		Address[] toUser = InternetAddress.parse("pamela22neves@gmail.com, pamelajavieljavatest@gmail.com");
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, "Pamela Neves Javiel")); /*Quem está enviando*/
		message.setRecipients(Message.RecipientType.TO, toUser);/*Destinatário*/
		message.setSubject("Chegou o email enviado pelo JavaMail");
		message.setText("Olá Programador, você acaba de receber um e-mail enviado com Java do curso Formação Java Web do Alex");
		Transport.send(message);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
   
}
