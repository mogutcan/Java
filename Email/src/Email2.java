import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.MessagingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Email2 extends JFrame implements ActionListener{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextArea textArea = new JTextArea(30,20);
	
	
	JButton gonder = new JButton("Gönder");
	JTextField konu = new JTextField(20);
	JTextField alici = new JTextField(20);
	
	JLabel etiket_konu = new JLabel("Konu");
	JLabel etiket_kime = new JLabel("Kime");
	JLabel mesaj       = new JLabel("Mesaj");
	String govde,subject,sender,mesajı_alan;
	String [] mesajıalan ;
	
	
	
	 JFrame email_penceresi = new JFrame();
	
	public void gonder() {
		
		
		Container c = new Container();
		c = email_penceresi.getContentPane();
		
		
		c.add(etiket_konu);
		
		konu.addActionListener(this);
		c.add(konu);
		
		c.add(etiket_kime);
		
		alici.addActionListener(this);
		c.add(alici);

		
		c.add(mesaj);
		
		textArea.setLineWrap(true);
		c.add(textArea);
		
		gonder.addActionListener(this);
		c.add(gonder);
		
		c.setLayout(new FlowLayout(2,5,10));
		
		email_penceresi.setLocation(500, 150);
		email_penceresi.setSize(300, 600);
		email_penceresi.setVisible(true);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
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
	
}
