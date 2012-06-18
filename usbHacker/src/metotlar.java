import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class metotlar {
	
	// kaynak dosya : srcFolder
	static File srcFolder;
	public static void usb_girisi_bekle() {
		
		
		// kopyalanacak klasor : destFolder
		File destFolder = new File("c:\\test");
		
		// Desteklenen aygýtlar
		// CD-ROM("E"), Disket surucusu("A"), usb surucu
    	String[] usb_bulucu = { "A", "B", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", 
    			"P", "R", "S", "T", "U", "V", "Y", "Z", "X", "W"
    	};
    	
    	int i = 0;
    	srcFolder = new File(usb_bulucu[i]+":\\");
    	
    	while (!srcFolder.exists() && i< usb_bulucu.length ) {
    		
    		i++;
    		if (i == usb_bulucu.length)
    			i = 0;
    		
    		srcFolder = new File(usb_bulucu[i]+":\\");
    	}
    		
    		
    			System.out.println(srcFolder);
    		
    try{
        	kopyala(srcFolder,destFolder);
           
    	}catch(IOException e){
        	e.printStackTrace();
        	 // Hata, cik
                System.exit(0);
           }
        
	}
	
	
	public static void kopyala(File src, File dest) throws IOException{
		
		if(src.isDirectory()){
		  		
			// hedef klasor yok ise, yarat
		    if(!dest.exists()){
		    	
		    	dest.mkdir();
		    	System.out.println("Directory copied from " 
		    			+ src + "  to " + dest);
		    		
		    }
		 
		    String files[] = src.list();
		 	for (String file : files) {
		    			
		 		if (file.contains(".pdf") || !file.contains(".")) {
		    		
		 			File srcFile = new File(src, file);
		    		File destFile = new File(dest, file);
		    		
		    		// ozyineli kopyalama
		    		kopyala(srcFile,destFile);
		    	}
		    }
		}
		else{

			InputStream in = new FileInputStream(src);
		    OutputStream out = new FileOutputStream(dest); 
		    byte[] buffer = new byte[1024];
		    int length;
		    
		    while ((length = in.read(buffer)) > 0){
		    	out.write(buffer, 0, length);
		    	    	        
		    }
		    	    	        
		    in.close();
		    out.close();
			System.out.println("File copied from " + src + " to " + dest);
		}
	}
}