import java.io.File;


import javax.swing.JOptionPane;


public class Cleaner {
	
	
	String mesajlar = "";
	public void delete(File file) {
		 
			if(file.isDirectory()){
				
				while (file.list().length > 0) {
		    				
		    		String files[] = file.list();
		    		
					for (String temp : files) {
				    	  
						File fileDelete = new File(file, temp);
						
						mesajlar += "Siliniyor => " +fileDelete+ "\n";
						
				        fileDelete.delete();
				        	   
					}
					
				}
				
				JOptionPane.showMessageDialog(null, "Çerezler silindi");
		    		
			}
		}
	}	

