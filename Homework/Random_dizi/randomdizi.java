
import javax.swing.*;
public class randomdizi {


	public static void main(String[] args) {
		
		
		
		
		String aranacak = JOptionPane.showInputDialog("Aranacak Sayiyi Girin : ");
		
			
			int [] dizi = new int[10];
			
			for (int i= 0; i< 10; i++) {
				
				int uretilen = (int)(20*Math.random());
				
				dizi[i] = uretilen;
				
				
				
				}
			
			int kontrol = 0;
			
			for(int i = 0; i < 10; i++) {
				
				if( dizi[i] == Integer.parseInt(aranacak) ) {
					
					
					kontrol = 1;
					JOptionPane.showMessageDialog(null, "Aradığınız "+(String)aranacak+ 
							                       
							                        " karakteri dizi içerisinde bulundu!" );
					break;
					
				}
				
			}
			
			if 	(kontrol == 0)
				JOptionPane.showMessageDialog(null, "Bulunamadı");
			
			
			
		}

}


