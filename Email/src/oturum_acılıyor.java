import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class oturum_acılıyor  {

	
	ImageIcon icon;
	JLabel resim_alanı ;
	JFrame anacerceve = new JFrame();
	
	

	public void ekran() {
	
	
	
	Container c = new Container();
	c = anacerceve.getContentPane();

	
	icon = new ImageIcon("loading.gif");
	resim_alanı = new JLabel(icon);
	c.add(BorderLayout.CENTER,resim_alanı);

	anacerceve.setSize(300,500);
	anacerceve.setLocation(500, 150);
	anacerceve.setResizable(false);
	anacerceve.setVisible(true);
	

}


	
	public static void main(String[] args) {
		
		oturum_acılıyor o = new oturum_acılıyor();
		o.ekran();

	}

}
