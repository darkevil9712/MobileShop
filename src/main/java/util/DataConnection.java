package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnection {
	 public static Connection createConnection(){
	        Connection con = null;
	        try{
	            // Khai báo kết nối CSDL
	            String url = "jdbc:mysql://localhost:3306/webbanhang?autoReconnect=true&useSSL=false";
	            String username = "root";
	            String password = "";
	            // Kết nói csdl
	            Class.forName("com.mysql.jdbc.Driver");  
	            con = DriverManager.getConnection(url,username,password);  
	        }
	        catch(Exception ex){
	            ex.printStackTrace();
	            System.out.println("Bị lỗi");
	        }
	        
	        return con;
    }
}
