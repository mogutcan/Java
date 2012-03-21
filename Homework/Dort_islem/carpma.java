import javax.swing.JOptionPane;
public class carpma {
	
	
	void carp() {
	
	int sonuc;
	

	String a = JOptionPane.showInputDialog("1.sayıyı gir");
	
	String b = JOptionPane.showInputDialog("2.sayıyı gir");
	
	sonuc = Integer.parseInt(a) * Integer.parseInt(b);
	
	JOptionPane.showMessageDialog(null, sonuc);
	

}
}
