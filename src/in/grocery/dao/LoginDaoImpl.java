package in.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.grocery.dbconnection.DBConnect;


public class LoginDaoImpl implements LoginDao {

	Connection conn=null;
	PreparedStatement ps;
	boolean result;
	ResultSet rs=null;
	
	@Override
	public boolean adminLogin(String email, String pass) {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("inside admin login");
			conn=DBConnect.getConnection();
			String sql="select adminemail,adminpass from admin where adminemail=? and adminpass=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			System.out.println(ps);
			ResultSet rs=ps.executeQuery();
			if (rs.next())
				return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return false;
	}

	@Override
	public boolean customerLogin(String email, String pass) {
		try
		{
			System.out.println("inside customer login");
			conn=DBConnect.getConnection();
			String sql="select customeremail,customerpassword from customer1 where customeremail=? and customerpassword=?"	;
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			System.out.println(ps);
			ResultSet rs=ps.executeQuery();
			if (rs.next())
				return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return false;
	}

	@Override
	public boolean adminChangePassword(String email, String newpass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean forgetPassword(String email, String newpass) {
		// TODO Auto-generated method stub
		return false;
	}

}

