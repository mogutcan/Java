import java.sql.*;

public class bagla 
{
	 static Statement s = null;
	 ResultSet rows;
	 
	 static Connection conn;
  public static void main(String[] args) {
	  
	  veritabanina_baglan();
	  
  }
  
  
  public static void veritabanina_baglan() {
	  
	  
  System.out.println("MySQL Connect Example.");
  conn = null;
  
  // Veritabanýnýn bulundugu yol 
  String url = "jdbc:mysql://localhost/";
  
  // Veritabaný adýmýz "gunluk"
  String dbName = "gunluk";
  
  
  String userName = "root"; 
  String password = "000000";
  try {
	  
	  Class.forName("com.mysql.jdbc.Driver");
	  conn = DriverManager.getConnection(url+dbName ,userName,password);
	  System.out.println("Connected to the database");
	  //conn.close();
	  //System.out.println("Disconnected from database");
	  
  } catch (Exception e) {
	  System.out.println("hata");
      e.printStackTrace();
  }
  
 
 
  
  try {
	  s = conn.createStatement();
	  
  } catch (SQLException e) {
	// TODO Auto-generated catch block
	  e.printStackTrace();
  }
 
}
}