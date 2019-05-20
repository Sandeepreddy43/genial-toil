package com.reg.gt.Admin;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
		
	@SuppressWarnings({ "unused" })
	public void Mailsend(String tomail) {
		
		final String senderEmail = "genialtoil@gmail.com";
		final String password = "windows#10";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(prop, 
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(senderEmail, password);
				}
					});
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress("genialtoil@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(tomail));
			message.setSubject("Greetings from 'GT-Team'");
			EmployeeBean eb= new EmployeeBean();
			String ename=getName();
			System.out.println(ename+"************");
			message.setText("Mr/Ms. "+ename+"\nYou are Successfully Registered with Genial Toil - Web APP!!\n\nThanks&Regards\nTeam - GT");
			
			Transport.send(message);
			System.out.println("Message sent Succesfully");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
	String name;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
}
