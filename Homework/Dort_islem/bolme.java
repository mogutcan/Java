import javax.swing.JOptionPane;


public class bolme {



	void bol() {
	
	double sonuc ;
	

	String a = JOptionPane.showInputDialog("1.sayıyı gir");
	
	String b = JOptionPane.showInputDialog("2.sayıyı gir");
	
	
	sonuc = Float.parseFloat(a) / Float.parseFloat(b);
	
	JOptionPane.showMessageDialog(null, sonuc);
	
}
}
