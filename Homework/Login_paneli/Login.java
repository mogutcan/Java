import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.util.Arrays;
import javax.swing.*;


public class Login extends JFrame implements ActionListener {

	JTextField user ;
	JPasswordField id ;
	JButton buton ;
	
	JLabel label1,label2,label3;
	
	
	public Login() {
		
		
		setLayout( new FlowLayout());
		
		
		label1 = new JLabel("Kullanıcı adı");
		add(label1);
		
		user = new JTextField(10);
		add(user);
		user.addActionListener(this);
		
		label2 = new JLabel("Parola");
		add(label2);
		
		id = new JPasswordField(6);
		add(id);
		id.addActionListener(this);
		
		
		buton = new JButton("Giris");
		add(buton);
		buton.addActionListener(this);
		
		
		label3 = new JLabel();
		add(label3);
		
		
		
		pack();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String username = user.getText();
		
		char[] password = id.getPassword();
		
		char[] auth = new char[] {'f', 'o', 'o' };
		
		if (  username.equals("mehmet") && Arrays.equals(password, auth)) 
			
				label3.setText("Giris yapıldı");
			
			
	    else 
				
				label3.setText("Kullanıcı adı ve/veya parola hatalı");		
		}
	
		
	
	public static void main (String[] args) {
		
		Login l = new Login();
		l.setVisible(true);
		l.setSize(500, 250);
		l.setLocation(500, 150);
	
		
	}

}
