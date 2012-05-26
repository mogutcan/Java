import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class sql_sorgularý {

	
	bagla by = new bagla();
	
	JCalendar j = new JCalendar();
	
	String not_listesi = "";
	

	
	public void kaydet(String tarih, String not) {
		
		by.veritabanina_baglan();
		
	
	
		String kaydedilecek = "INSERT INTO deneme " +
		 
				 
				 "VALUES ( NULL, ' " + tarih+ " ' ,"  +
				 
				 "  ' " + not + " ' "  +
				 ")";

		 
		 try {
			 
			by.s.executeUpdate(kaydedilecek);
			JOptionPane.showMessageDialog(null, "Kaydedildi");
			by.conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 	
	}
	
	public void listele() {
		
		ResultSet rs = null;
		
		by.veritabanina_baglan();
		
		
		String listeleme_sorgusu  = "SELECT * FROM deneme WHERE tarih = ' " + j.bugun+ " ' ";
		
		
		try {
			
			
			rs = by.s.executeQuery(listeleme_sorgusu);
			
			/*
			 * secilen tarihe ait sorgu "true" ise
			 * 
			 * not_listesine tablonun not sütununu ekle
			 * 
			 * bir sonraki sorgu "true" olduðu müddetçe
			 * bu iþlemi devam ettir.
			 */
			
			if (rs.first()) {
				
				not_listesi += rs.getString(3)+ "\n";
				
			
				while (rs.next()) {
					
					// Sorgudaki tablonun 3.kolonunu sec, yani not kolonunu sec
					not_listesi += rs.getString(3)+ "\n";
					
				
					}
				
				JOptionPane.showMessageDialog(null,not_listesi,"Bugüne ait notlarýnýz",
						JOptionPane.PLAIN_MESSAGE);
		
			}
			
			else {
				
				JOptionPane.showMessageDialog(null, "Bugüne ait not bulunamadý");
			}
				
			by.conn.close();
			
		}
	
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
}
	

