import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;






public class timeCleaner extends Cleaner {
	

	Cleaner baslat = new Cleaner();
	
	static File dosya;
	javax.swing.Timer tx ;
	arayuz t ;
	
	// Override yapıyoruz ...
	public void delete(File file) {
		
		dosya = file;
		t = new arayuz();
		int a= t.sureler.getSelectedIndex();
		int sure_sec;
		
		if (a == 0) {
			sure_sec = 300000;
		}
		else if (a == 1) {
			sure_sec = 10800000;
		}
		else {
			sure_sec = 21600000;
		}

	
		tx = new javax.swing.Timer(sure_sec, new ClockListener());
        tx.start();
        
    		
	}
	
	
	class ClockListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			baslat.delete(dosya);
			JOptionPane.showMessageDialog(null, "Silindi");
			
			if (t.durakla){
				
				tx.stop();
				
			}
		}
	}
}
	

	
