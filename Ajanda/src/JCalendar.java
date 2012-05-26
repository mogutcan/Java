//**********************************************************************
// Package
//**********************************************************************





import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.Calendar;
import org.freixas.jcalendar.*;




class JCalendar extends JFrame implements ActionListener{
	

	JPanel panel1;
	JLabel etiket;
	
	JTextArea not_yaz;
	
	JButton kaydet;
	JButton listele;
	
	
	static String bugun;
	
	
	static String kaydedilecek_not;
	
	
	public void JCalendar() {

    
		setTitle("Not Defteri Uygulamasý");
    
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
   

		MyDateListener listener = new MyDateListener();

		JCalendarCombo calendar2 = new JCalendarCombo(JCalendarCombo.DISPLAY_DATE, false);
		calendar2.addDateListener(listener);

		etiket = new JLabel("Bir not yaz ");
		add(etiket);

    
		JPanel panel2 = new JPanel(new BorderLayout());
    	panel2.add(calendar2, BorderLayout.EAST);
    	contentPane.add(panel2, BorderLayout.EAST);
    
    	not_yaz = new JTextArea(20,40);
    	add(not_yaz);
	
    	kaydet = new JButton("Kaydet");
		kaydet.addActionListener(this);
		add(kaydet);
	
	
		listele = new JButton("Listele");
		listele.addActionListener(this);
		add(listele);
	
	

		pack();
		setVisible(true);
		setSize(500,500);
		setLocation(450,100);
   
}
	
 public static  void main(String[] args) {
		 
		 
		 JCalendar basla = new JCalendar(); 
		 basla.JCalendar();
		 
	 	 }
 

	public class MyDateListener implements DateListener {

		@SuppressWarnings("deprecation")
		public void dateChanged(DateEvent e){
		
			Calendar c = e.getSelectedDate();
		
			if (c != null) {
			
				String yil =    Integer.toString(c.getTime().getYear() +1900);
			
				String ay  =    Integer.toString(c.getTime().getMonth() +1) ; 
			
			
				String gun = 	Integer.toString( c.getTime().getDate() ) ;
			
				
				bugun =  yil +"-" +ay+ "-" + gun ;
		
			}
			
			else {
				System.out.println("No time selected.");
			}
		}
		
		
		


}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	
	 bagla b = new bagla();
	 sql_sorgularý sorgu = new sql_sorgularý();
	
	if (e.getSource() == kaydet) {
		
		kaydedilecek_not = not_yaz.getText();
		sorgu.kaydet(bugun, kaydedilecek_not);
	}
	
	
	if (e.getSource() == listele) {
		
		sorgu.listele();
	}
}
}
