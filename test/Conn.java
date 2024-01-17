

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HARDY
 */
public class Conn {
    public static Connection connexionPostgres(){
      Connection con=null;
      try {
        
        Class.forName("org.postgresql.Driver");
        String URLS= "jdbc:postgresql://localhost/voyage";
        String USER="postgres";
        String MDP="mdpprom15B";
        con=DriverManager.getConnection(URLS,USER,MDP);
      } catch (Exception e) {
    	  e.printStackTrace();
      }
     return con;
  }
}
