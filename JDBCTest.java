package JDBC;

//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.*;

public class JDBCTest {

   private static final String URL = "jdbc:mysql://localhost:3306/test";
   private static final String USER = "root";
   private static final String PASSWORD = "root";

   public static void main(String[] args) {
      ResultSet rs = null;
      try {
          Class.forName("com.mysql.jdbc.Driver");//驱动的类名
          //服务器的IP地址和端口号，数据库的名字
          Connection conn =
             (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
          Statement stmt = (Statement) conn.createStatement();
          rs = stmt.executeQuery("select * from student");
          while(rs.next()) {
             System.out.println("Connect successfully!");
             System.out.println("ID: "+rs.getInt(1));
             System.out.println("Name: "+rs.getString(2));
             System.out.println("Age: "+rs.getInt(3));
          }
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
      finally  
        {  
            if(rs!=null)  
            {  
                try {  
                    rs.close();  
                } catch (SQLException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
            }  
        }
   }
}