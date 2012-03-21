import javax.swing.JOptionPane;


public class ana_islem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String islem = JOptionPane.showInputDialog("Toplama için 1\nÇıkarma için 2\nÇarpma için 3\nBölme için 4");
		
		
		switch (Integer.parseInt(islem)) {
		
		case 1:
			
			toplama t = new toplama();
			
			t.topla();
			
			break;
			
		case 2:
			
			cikarma c = new cikarma();
			
			c.cikar();
			break;
			
		case 3:
			
			carpma ç = new carpma();
			
			ç.carp();
			
			break;
			
		case 4:
			
			bolme b = new bolme();
			
			b.bol();
			break;
			
		
		
		
		
		}
		
		

	}

}
