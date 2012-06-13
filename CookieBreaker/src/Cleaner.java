import java.io.File;


import javax.swing.JOptionPane;


public class Cleaner {
	
	
	static String mesajlar = "";
	
	public void delete(File file) {
	 
	    	if(file.isDirectory()){
	 
	    		// bos ise , sil
	    		if(file.list().length==0){
	 
	    		   file.delete();
	    		   mesajlar += "Siliniyor => " + file.getAbsolutePath()+ "\n";
	    		   
	    		}else{
	 
	    		   
	        	   String files[] = file.list();
	 
	        	   for (String temp : files) {
	        	      
	        	      File fileDelete = new File(file, temp);
	        	      delete(fileDelete);
	        	   }
	 
	        	   //klasor icerigi bos ise, klasoru sil
	        	   if(file.list().length==0){
	           	     file.delete();
	           	     mesajlar += "Siliniyor => " + file.getAbsolutePath()+ "\n";
	           
	        	   }
	    		}
	    		
	 
	    		}else{
	    			
	    			// dosya ise , sil
	    			file.delete();
	    			mesajlar += "Siliniyor => " + file.getAbsolutePath()+ "\n";
	    		}
	    	}
}

	