import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class hesapmakinesi extends JFrame implements ActionListener {
	
	
	JButton a, b, c, d, m, f, g, h, i, j;
	JButton carp, esittir, topla, cıkar, bol, clear;
	JLabel ekran, ekran2, ekran3, ekran4;
	
	String hafiza,ara;
	public String islec;
	
	// Constructor = yapılandırıcı ayarlar olusturuyoruz.
	public hesapmakinesi(){
		
	
		setLayout(new GridLayout(5,3));
		
		ekran = new JLabel();
		add(ekran);
		
		ekran2 = new JLabel();
		add(ekran2);
		
		ekran3 = new JLabel();
		add(ekran3);
		
		
		ekran4 = new JLabel();
		add(ekran4);
		
		// FIXME!!! 4 ekran yerine tek ekran ?
		
		topla= new JButton("+");
		add(topla);
		topla.addActionListener(this);
		
		cıkar= new JButton("-");
		add(cıkar);
		cıkar.addActionListener(this);
		
		bol= new JButton("/");
		add(bol);
		bol.addActionListener(this);
		
		
		carp= new JButton("X");
		add(carp);
		carp.addActionListener(this);
		
		
		a = new JButton("1");
		add(a);
		a.addActionListener(this);
		
	
		b = new JButton("2");
		add(b);
		b.addActionListener(this);
		
		
		c = new JButton("3");
		add(c);
		c.addActionListener(this);
		
		
		d = new JButton("4");
		add(d);
		d.addActionListener(this);
		
		m = new JButton("5");
		add(m);
		m.addActionListener(this);
		
		f = new JButton("6");
		add(f);
		f.addActionListener(this);
		
		g = new JButton("7");
		add(g);
		g.addActionListener(this);
		
		h = new JButton("8");
		add(h);
		h.addActionListener(this);
		
		i = new JButton("9");
		add(i);
		i.addActionListener(this);
		
		
		j = new JButton("0");
		add(j);
		j.addActionListener(this);
		
		clear = new JButton("C");
		add(clear);
		clear.addActionListener(this);
		

		esittir = new JButton("=");
		add(esittir);
		esittir.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == a) 
			
			ekran.setText(ekran.getText() +"1");
		
		if (e.getSource() == b) 
			
			ekran.setText(ekran.getText() +"2");
		
		
		if (e.getSource() == c) 
			
			ekran.setText(ekran.getText() +"3");
		
		if (e.getSource() == d) 
			
			ekran.setText(ekran.getText() +"4");
		
		if (e.getSource() == m )
			
			ekran.setText(ekran.getText() +"5");
		
		if (e.getSource() == f) 
			
			ekran.setText(ekran.getText() +"6");
		
		if (e.getSource() == g) 
			
			ekran.setText(ekran.getText() +"7");
		
		if (e.getSource() == h) 
			
			ekran.setText(ekran.getText() +"8");
		
		if (e.getSource() == i) 
			
			ekran.setText(ekran.getText() +"9");
		
		if (e.getSource() == j) 
			
			ekran.setText(ekran.getText() +"0");
		
		if (e.getSource() == clear) { 
			hafiza = "";
			ekran.setText("");
		}
		
		if (e.getSource() == carp) {
			
			hafiza = ekran.getText() ;
			islec = "x";
			ekran.setText("");
			 
		}
		
		if (e.getSource() == topla) {
			
			hafiza = ekran.getText() ;
			islec = "+";
			ekran.setText("");
			 
		}
		

		if (e.getSource() == bol) {
			
			hafiza = ekran.getText() ;
			islec = "/";
			ekran.setText("");
			 
		}


		if (e.getSource() == cıkar) {
			
			hafiza = ekran.getText() ;
			islec = "-";
			ekran.setText("");
			 
		}
		
		if (e.getSource() == esittir) {
			
			int a = Integer.parseInt(ekran.getText()); 
			int b = Integer.parseInt(hafiza) ;
		    
		    islemler(islec, a, b);
		}
			
		
			
	}
	
	public void islemler(String islec, int sayi1, int sayi2 ) {
		
		int sonuc ;
		float kesirli_sonuc;
		
		if (islec == "x") {
			
			sonuc = sayi1 * sayi2;
			hafiza = Integer.toString(sonuc);
			ekran.setText(Integer.toString(sonuc));
		}
		
		
		if (islec == "+") {
			
			sonuc = sayi1 + sayi2;
			hafiza = Integer.toString(sonuc);
			ekran.setText(Integer.toString(sonuc));
		}
		
		if (islec == "-") {
			
			sonuc = sayi2 - sayi1;
			hafiza = Integer.toString(sonuc);
			ekran.setText(Integer.toString(sonuc));
		}
		
		// FIXME!!! Bolme isleminde aksaklık var
		if (islec == "/") {
			
			kesirli_sonuc = (float) sayi2/sayi1;
			sonuc = (int) kesirli_sonuc;
			
			hafiza = String.valueOf(kesirli_sonuc);
			
			ekran.setText(hafiza);
		}

}
	
	public static void main(String[] args) {
		
		hesapmakinesi h = new hesapmakinesi();
		h.setVisible(true);
		h.setSize(250, 400);
		h.setLocation(500,150);  // Ekran konumlandırması
		
	}

}
