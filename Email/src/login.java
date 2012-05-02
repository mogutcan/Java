
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.MessagingException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingWorker;

import javax.swing.JTextField;


public class login extends JFrame implements ActionListener{



	private static final long serialVersionUID = 1L;
	
	JFrame anapencere1 = new JFrame();
	
	Email2 gonderi = new Email2();

	oturum_acılıyor t = new oturum_acılıyor();
	
	String [] oturummesajıalan = {"mogutcan@bil.omu.edu.tr"};
	
	JLabel user,user_id;
	JTextField usertext;
	JPasswordField user_id_text;
	
	JButton oturum_ac;
	
	public void yapı() {
		
		Container c = new Container();
		c = anapencere1.getContentPane();
		
		user = new JLabel("E-posta adresi");
		c.add(user);
		
		
		usertext = new JTextField(25);
		usertext.addActionListener(this);
		c.add(usertext);
		
		
		
		user_id  = new JLabel("Parola");
		c.add(user_id);
		
		user_id_text = new JPasswordField(25);
		user_id_text.addActionListener(this);
		
		c.add(user_id_text);
		
		oturum_ac = new JButton("Oturum Aç");
		oturum_ac.addActionListener(this);
		c.add(oturum_ac);
		
		
		c.setLayout(new FlowLayout());
		
		anapencere1.setSize(300, 500);
		anapencere1.setLocation(500, 150);
		anapencere1.setResizable(false);
		anapencere1.setVisible(true);
		
		
		
		
		
		
	
	}
	
	
	
	public static void main(String[] args) {
		
		login L = new login();
		L.yapı();
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		

		String s = new String(user_id_text.getPassword());
		
		
		SimpleMailSender oturum_acma_kontrolu = new SimpleMailSender(
				"smtp.gmail.com",usertext.getText(), s, usertext.getText(),
				"OturumAcmaKontrolu", oturummesajıalan, usertext.getText()
				
				);
		

		oturum_acılıyor ac = new oturum_acılıyor();
		
		if (e.getSource() == oturum_ac){
			
			anapencere1.setVisible(false);
			t.anacerceve.setVisible(true);
			
			
			
			try {
				
				oturum_acma_kontrolu.sendMail();
				
				t.anacerceve.setVisible(false);
				gonderi.gonder();
			
		
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
			
		
			
		
		}
			

	}
	}




			
	
		


