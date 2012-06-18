import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class arayuz extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JFrame cerceve;
	
	JButton basla;
	JButton dur;
	
	public arayuz() {
		
		cerceve = new JFrame();
		cerceve.setLayout(new FlowLayout());
		
		basla = new JButton("Baþlat");
		basla.addActionListener(new UsbListener());
		
		dur = new JButton("Durdur");
		dur.addActionListener(new UsbListener());
		
		cerceve.add(basla);
		cerceve.add(dur);
		
		cerceve.setSize(250,250);
		cerceve.setVisible(true);
		
	}
	
	
	// inner class
	class UsbListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == basla) {
				
				metotlar.usb_girisi_bekle();
			}
			
			if (e.getSource() == dur) {
				System.exit(0);
			}
			
		}
		
	}

}
