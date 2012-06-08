import javax.swing.JFrame;

import javax.swing.JTextArea;


public class raporlama extends JFrame {
	
	JTextArea raporalani;
	
	JFrame pencere;
	
	public raporlama(){
		
	
		pencere = new JFrame();
		raporalani = new JTextArea(15,20);
		raporalani.setLineWrap(true);
		
		
		pencere.setSize(700,300);
		pencere.setLocation(450,200);
		pencere.add(raporalani);
		pencere.setVisible(true);
		
		
	}
}
