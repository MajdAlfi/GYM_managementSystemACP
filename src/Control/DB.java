package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;




public class DB {
   static final String DB_URL = "jdbc:mysql://192.168.64.2/Name";
   static final String USER = "Name";
   static final String PASS = "passmajd2001";
   public void func() {
      System.out.println("Connecting to a selected database...");
      // Open a connection
      
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {	
    	  
         System.out.println("Connected database successfully...");  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
   
}
