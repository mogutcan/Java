import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;




public class arayuz extends JFrame implements ActionListener,ItemListener {
	
	JFrame anacerceve;

	JButton simdi_tara;
	JButton zamanla;
	JButton durdur;
	boolean durakla;
	
	JCheckBox rapor;
	boolean state;
	
	ImageIcon icon;
	JLabel resim_alani;
	

	JFrame pencere;
	JLabel bilgi;
	JTextField pc;
	JButton devam;
	
	File f1 ;
	
	public static JComboBox sureler;
	
	
	
	public void start(){
		
		anacerceve = new JFrame();
		anacerceve.setLayout(new FlowLayout());
		
		
		
		
		rapor = new JCheckBox("Ayrýntýlý rapor",false);
		rapor.addItemListener(this);
		anacerceve.add(rapor);
		
		simdi_tara = new JButton("Þimdi Tara");
		simdi_tara.addActionListener(this);
		anacerceve.add(simdi_tara);
		
		
		String[] sure = {"5 dakikada bir","3 saatte bir","6 saatte bir"};
		sureler = new JComboBox(sure);
		sureler.setSelectedIndex(0);
		sureler.addActionListener(this);
		anacerceve.add(sureler);
		
		zamanla = new JButton("Zamanla");
		zamanla.addActionListener(this);
		anacerceve.add(zamanla);
		
		
		durdur = new JButton("Durdur");
		durdur.addActionListener(this);
		anacerceve.add(durdur);
		
		
		icon = new ImageIcon("clean.jpg");
		resim_alani = new JLabel(icon);
		anacerceve.add(resim_alani);
		
		
		anacerceve.setLocation(500,150);
		anacerceve.setVisible(false);
		anacerceve.setSize(250,450);
		
		
			
			
		pencere = new JFrame();
		pencere.setLayout(new FlowLayout());
			
			
		bilgi = new JLabel("Bilgisayardaki kullanýcý adýnýz  ");
		pencere.add(bilgi);
			
		pc = new JTextField(30);
		pencere.add(pc);
			
		devam = new JButton("Devam");
		devam.addActionListener(this);
		pencere.add(devam);
			
		pencere.setSize(400,300);
		pencere.setLocation(500,150);
		pencere.setVisible(true);
			
	
	}
	
	
	

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if (rapor.isSelected()) {
			
			
			state = true;
	
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// Program kullandýgýnýz isletim sistemini tanýyor!
		
		String kullanici = pc.getText();
		String os = System.getProperty("os.name");
		
		if(os.equals("Windows 7"))
			
			f1 = new File("C:\\Users\\"+kullanici+"\\AppData\\Roaming\\Microsoft\\Windows\\Cookies\\Low");
		
		else if(os.equals("Windows Xp"))
			
			f1 = new File("C:\\Documents and Settings\\"+kullanici+ "\\Cookies");
		
		else
			// Linux ?
			f1 = new File("C:\\Documents and Settings\\"+kullanici+ "\\Cookies");
			
		
		if (e.getSource() == simdi_tara){
			
			if (state) {
				
				state = false;
				
				raporlama y = new raporlama();
				
				Cleaner c = new Cleaner();
					
				c.delete(f1);
				
				
				y.raporalani.setText(c.mesajlar);
				
				
				
			}
			else {
			
			Cleaner c = new Cleaner();
			
			c.delete(f1);

			}
			
		}
		
		if (e.getSource() == zamanla) {
			
			timeCleaner t = new timeCleaner();
			t.delete(f1);
		}
		
		if (e.getSource() == durdur){
			
			durakla = true;
			
		}
		
		if (e.getSource() == devam){
			
			if(!f1.exists())
				JOptionPane.showMessageDialog(null, "Hesap adýnýzý yanlýþ girdiniz");
			else{
			
				pencere.setVisible(false);
				anacerceve.setVisible(true);
			}
		}
	}
}