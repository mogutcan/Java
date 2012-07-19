import java.awt.FlowLayout;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;




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
	
	String[] sure = null;
	
	
	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuItem1, menuItem2;
	
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
		anacerceve.setVisible(true);
		anacerceve.setSize(250,450);
		
		
			
		PopupMenu popup = new PopupMenu();
		MenuItem defaultItem = new MenuItem("English");
		defaultItem.addActionListener(this);
		
		MenuItem ikinciitem = new MenuItem("Turkish");
		ikinciitem.addActionListener(this);
		
		popup.add(defaultItem);
		popup.add(ikinciitem);
		

		//Create the menu bar.
		menuBar = new JMenuBar();

		//Build the first menu.
		menu = new JMenu("Language");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		
		
		
		menuItem1 = new JMenuItem("English", KeyEvent.VK_T);
		menuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem1.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		menuItem1.addActionListener(this);
		menu.add(menuItem1);
		
		
		menuItem2 = new JMenuItem("Turkish",KeyEvent.VK_T);
		menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem2.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		menuItem2.addActionListener(this);
		menu.add(menuItem2);
		
		menuBar.add(menu);
		
		anacerceve.setJMenuBar(menuBar);
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
		
		String kullanici = System.getProperty("user.name");
		String os = System.getProperty("os.name");
		
		if(os.equals("Windows 7"))
			f1 = new File("C:\\Users\\"+kullanici+"\\AppData\\Roaming\\Microsoft\\Windows\\Cookies\\Low");
		
		else if(os.equals("Windows XP"))
			f1 = new File("C:\\Documents and Settings\\"+kullanici+ "\\Cookies");
		
		else
			// Linux !!!
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
		
		if(e.getSource() == menuItem1) {
		
			simdi_tara.setText("Scan Now");
			zamanla.setText("Timer");
			durdur.setText("Stop");
			rapor.setText("Report");
		}
		
		if(e.getSource() == menuItem2) {
			
			simdi_tara.setText("Þimdi Tara");
			zamanla.setText("Zamanla");
			durdur.setText("Durdur");
			rapor.setText("Ayrýntýlý rapor");
			
		}	
	}
}