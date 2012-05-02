package org.javablog;
 


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


import java.awt.event.*;

import javax.mail.MessagingException;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.AncestorListener;

import org.javablog.SimpleMailSender;

import java.awt.FlowLayout;
import java.awt.GridLayout;

 
@SuppressWarnings("unused")
public class SimpleMailSender
{
	private String smtpHost; //Host
	private String smtpAuthUser;
	private String smtpAuthPassword;
	private String mailBody;
	private String mailSubject;
	private String mailSender;
 
	private String[] mailList;
	private String[] attachmentFiles;
	
	
 
	public SimpleMailSender(String host, String authUser,
			String authPassword, String body, String subject,
			String[] list, String sender)
	
	
	{
		smtpHost = host;
		smtpAuthUser = authUser;
		smtpAuthPassword = authPassword;
		mailBody = body;
		mailSubject = subject;
		mailSender = sender;
		mailList = list;
		//attachmentFiles = files;
 
	}
	
	 
	public void sendMail() throws MessagingException
	{
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		//this property is required
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host", smtpHost);
		//required if SMTP server requires authentication
		properties.put("mail.smtp.auth", "true");
 
		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getDefaultInstance(properties, auth);
		if (session == null) {
			
			JOptionPane.showMessageDialog(null, "hata");
		}
		
 
		//InternetAddress class represents an Internet email address
		//Hence, lets model our email addresses
 
		InternetAddress mailFrom = new InternetAddress(mailSender);
		InternetAddress[] mailTo = new InternetAddress[mailList.length];
 
		
		for(int i = 0; i < mailList.length; i++)
		{
			mailTo[i] = new InternetAddress(mailList[i]);
		}
 		
		//Modeling an email message
		//Message abstract class helps us to do this
		//MimeMessage which extends Message class represents a MIME style email message
		//We will represent entire email message in this form
		//Let's create an instance
 
		Message message = new MimeMessage(session);
		message.setFrom(mailFrom);
		message.setRecipients(Message.RecipientType.TO, mailTo);
		message.setSubject(mailSubject);
 
		/* Construct mail body parts */
 
		Multipart multipart = new MimeMultipart();
 
		//This represents message body part of mail
		MimeBodyPart bodyPartMessage = new MimeBodyPart();
		bodyPartMessage.setText(mailBody);
 
		//Add first body part to multipart
		multipart.addBodyPart(bodyPartMessage);
 
		//This represents message attachment part
		//will be added multipart later
 
		MimeBodyPart bodyPartAttachment = new MimeBodyPart();;
		FileDataSource fileDataSource;
 /*
		for(int i = 0; i < attachmentFiles.length; i++)
		{
			fileDataSource = new FileDataSource(attachmentFiles[i]);
			bodyPartAttachment.setDataHandler(new DataHandler(fileDataSource));
			bodyPartAttachment.setFileName(fileDataSource.getName());
			//Add all attachment files to bodypart in multipart object
			multipart.addBodyPart(bodyPartAttachment);
		}
 */
		//Add entire mail body to the message object
		message.setContent(multipart);
 
		//Finally send the message
		Transport.send(message);
 
	}
	//Testing our class
	
	public static void main(String[] args) throws MessagingException
	{
	 
	
		String[] to = new String[1];
		to[0] = "mogutcan@bil.omu.edu.tr";
		//to[1] = "mail@gmail.com";
		//String[] files = new String[2];
		//files[0] = "file1.txt";
		//files[1] = "file2.txt";
		
		

		Email e = new Email();
		
		e.setSize(300, 600);
		e.setVisible(true);
 
		
		SimpleMailSender mailSender = new SimpleMailSender(
				"smtp.gmail.com", "mogutcan@mf.omu.edu.tr", "19031902", "Burası mail gövdesidir",
				"Konu nedir ? ", to, "mogutcan@mf.omu.edu.tr"
				
				);
		
		
		
		//System.out.println("Mail has been sent successfully");
		
	} 
	
	
 
	private class SMTPAuthenticator extends Authenticator
	{
 
		public PasswordAuthentication getPasswordAuthentication() {
			String username = smtpAuthUser;
			String password = smtpAuthPassword;
			return new PasswordAuthentication(username, password);
		}
	}
 
}

class Email extends JFrame implements ActionListener{
	
	
	
	JTextArea textArea = new JTextArea(30,20);
	
	JButton gonder = new JButton("Gönder");
	JTextField konu = new JTextField(20);
	JTextField alici = new JTextField(20);
	
	JLabel etiket_konu = new JLabel("Konu");
	JLabel etiket_kime = new JLabel("Kime");
	JLabel mesaj       = new JLabel("Mesaj");
	String govde,subject,sender,mesajı_alan;
	String [] mesajıalan ;
	
	
	
	 
	
	
	
	public Email()  {
		
		setLayout(new FlowLayout(2,5,10));
		
		add(etiket_konu);
		konu.addActionListener(this);
		add(konu);
		
		add(etiket_kime);
		alici.addActionListener(this);
		add(alici);

		
		add(mesaj);
		
		// İlginc. Textarea dinlenmiyor ama calısıyor?
		add(textArea);
		
		
		gonder.addActionListener(this);
		add(gonder);
		
		
		
		
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		
		if (e.getSource() == gonder) {
			
			govde = textArea.getText();
			subject = konu.getText();
			mesajı_alan = alici.getText(); 
			
			mesajıalan = mesajı_alan.split(" ");
			
			
			
			
			
			
			String[] to = new String[1];
			to[0] = "mogutcan@bil.omu.edu.tr";
			
			SimpleMailSender mailSender = new SimpleMailSender(
					"smtp.gmail.com", "mogutcan@mf.omu.edu.tr", "19031902", govde,
					subject,mesajıalan, "mogutcan@mf.omu.edu.tr"
					
					);
			try {
				mailSender.sendMail();
				
			} catch (MessagingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Bir hata oluştu\nİnternet bağlantınızı kontrol edin");
			}
			
			
			
			
			
			textArea.setText("Basarıyla gönderildi");
			
			
			
		} 
	}
	
	public static void main(String[] args) {
		
		Email e = new Email();
		
		
		e.setSize(500, 750);
		e.setVisible(true);
		
		

		}
	
}