import javax.swing.JFrame;
import javax.swing.JScrollPane;

import javax.swing.JTextArea;


public class raporlama extends JFrame {
	
	JTextArea raporalani;
	
	JFrame pencere;
	JScrollPane scroll;
	
	public raporlama(){
		
	
		pencere = new JFrame();
		raporalani = new JTextArea(15,20);
		raporalani.setLineWrap(true);
		
		// scrollu jtext area icine yerlestir
		scroll = new JScrollPane(raporalani);
	
		pencere.setSize(700,300);
		pencere.setLocation(450,200);
	
		pencere.getContentPane().add(scroll);
		
		pencere.setVisible(true);
		
		
	}
	

}