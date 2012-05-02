import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class form extends JFrame implements ListSelectionListener, ActionListener {

	
	JFrame anapencere;
	JPanel yiyecekpaneli, icecekpaneli, hdpaneli;
	JLabel yiyecek;
	JButton ekle, ekle2;
	JList yiyeceklistesi, iceceklistesi, hdlistesi;
	JComboBox adetler, adetler2;
	JTextField toplam;

	int secilen_adet, secilen_adet2;
	
	public void form() {
		
		anapencere = new JFrame();
		
		String[] yiyecekler = {
				
								"Lahmacun       03 TL", 
								"Adana Kebap    10 TL", 
								"Urfa Kebap     08 TL", 				
								"Et sote        10 TL",
								"Açık Pide      06 TL",
								"Kıymalı Pide   09 TL",
								"Tavuk Sote     09 TL",
								"Kaşarlı Pide   09 TL",
							  };
		
		
		String[] icecekler = {
				
								"Kola           2 TL", "Fanta          2 TL",
								"Ayran          1 TL", "Meyve Suyu     1 TL",
								"Gazoz          1 TL", "Çay            1 TL",
								"Kahve          2 TL"
								
			  				  };
		String[] adet = {"1", "2", "3", "4", "5" };
		String[] adet2 = {"1", "2", "3", "4", "5" };
		adetler = new JComboBox(adet);
		adetler.setSelectedIndex(0);
		adetler.addActionListener(this);
		
		adetler2 = new JComboBox(adet2);
		adetler2.addActionListener(this);
		
		yiyecek = new JLabel(":::::MENÜ:::::");
		yiyeceklistesi = new JList(yiyecekler);
		yiyeceklistesi.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		yiyeceklistesi.addListSelectionListener(this);
		
	    JScrollPane scroll1 = new JScrollPane(yiyeceklistesi);
	    scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		yiyecekpaneli = new JPanel();
		yiyecekpaneli.add(scroll1);
		yiyecekpaneli.add(adetler);
		ekle = new JButton("Ekle");
		ekle.addActionListener(this);
		yiyecekpaneli.add(ekle);
		
		
		
		iceceklistesi = new JList(icecekler);
		iceceklistesi.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		iceceklistesi.addListSelectionListener(this);
		
	    JScrollPane scroll2 = new JScrollPane(iceceklistesi);
	    scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		icecekpaneli = new JPanel();
		icecekpaneli.add(scroll2);
		icecekpaneli.add(adetler2);
		
		ekle2 = new JButton("Ekle");
		ekle2.addActionListener(this);
		icecekpaneli.add(ekle2);
		
		
		
		
		
		
		
	
		hdlistesi = new JList();
		JScrollPane scroll3 = new JScrollPane(hdlistesi);
	    scroll3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		hdpaneli = new JPanel();
		hdpaneli.add(scroll3);

		toplam = new JTextField("Toplam");
		
	
		anapencere.getContentPane().add(yiyecekpaneli,BorderLayout.WEST);
		anapencere.add(yiyecek, BorderLayout.PAGE_START);
		anapencere.getContentPane().add(icecekpaneli,BoxLayout.Y_AXIS);
		anapencere.getContentPane().add(hdpaneli, BorderLayout.EAST);
		anapencere.getContentPane().add(toplam,BorderLayout.SOUTH);
		
	
		
		anapencere.setSize(850, 500);
		anapencere.setVisible(true);
		
		
		
	}
	
	
	
	
	
	
	




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		form f = new form();
	
		f.form();
	}







	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void hesapla(int bolum) {
		

		secilen_adet = adetler.getSelectedIndex();
		secilen_adet2 = adetler2.getSelectedIndex();
		List liste = yiyeceklistesi.getSelectedValuesList();
		List liste2 = iceceklistesi.getSelectedValuesList();
		
		int sonuc = 0;
		
		switch (bolum) {
			case 1:
				
				for (Object eleman : liste) {
					
					String s,c;
					int a,toplam ;
					
					float b ;
					s = (String)eleman;
					c = s.substring(15,17);
					a = Integer.parseInt(c);
					
					toplam = (secilen_adet +1 )*Integer.parseInt(c);
					sonuc = sonuc + toplam;
					System.out.println(toplam);
				}
				
				this.toplam.setText(Integer.toString(sonuc)+ " Türk Lirası Borcunuz Bulunmaktadır");
				break;
			case 2:
				
				
					for (Object eleman : liste2) {
						
						String s,c;
						int a,toplam ;
					
						float b ;
						s = (String)eleman;
						c = s.substring(15,16);
						a = Integer.parseInt(c);
					
					    toplam = (secilen_adet2 +1 )*Integer.parseInt(c);
					    sonuc = sonuc + toplam;
					 }
				
				this.toplam.setText(Integer.toString(sonuc)+ " Türk Lirası Borcunuz Bulunmaktadır");
				break;
		
	}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	
		
		if (e.getSource() == ekle) {
			
				hesapla(1);
				hdlistesi.setListData(yiyeceklistesi.getSelectedValues());
				
			
			}
				
		if (e.getSource() == ekle2 ) {
			
				hesapla(2);
				hdlistesi.setListData(iceceklistesi.getSelectedValues());
		
	}

}
}

