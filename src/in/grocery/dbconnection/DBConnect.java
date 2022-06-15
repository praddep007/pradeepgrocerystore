package in.grocery.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	static Connection conn=null;
	public static Connection getConnection(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver class loaded");
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mygrocery_pradeep","root","Pradeep"); 
			
			System.out.println("connected");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

}
