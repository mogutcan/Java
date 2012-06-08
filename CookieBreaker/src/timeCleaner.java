import java.io.File;




public class timeCleaner extends Cleaner {
	

	// Override yaptýrýyoruz ...
	public void delete(File file) {
		
		arayuz t = new arayuz();
		int a= t.sureler.getSelectedIndex();
		
		while(true){
			
			if (t.durakla)
				break;
			else{
		
				try {
				
				
					if (a == 0)
					
						Thread.sleep(5000);
				
					if (a == 1)
					
						Thread.sleep(6000);
				
					else
					
						Thread.sleep(7000);
				
					
				
					super.delete(file);
				
			
				} catch (InterruptedException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
			
			
			
				}
			}
		}
	}
}
