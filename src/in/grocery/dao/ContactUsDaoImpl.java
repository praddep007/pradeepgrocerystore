package in.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.grocery.dbconnection.DBConnect;
import in.grocery.pojo.ContactUs;

public class ContactUsDaoImpl implements ContactUsDao {
	Connection conn=null;
	PreparedStatement ps=null;
	boolean result;
	ResultSet rs=null;
 
	@Override
	public boolean customerFeedback(ContactUs contactobj) {
		
		try {
			System.out.println("inside dao customer feedback");
			conn=DBConnect.getConnection();
			String sql="insert into customerFeedback(cname,cemail,ccontact,ccomments)values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, contactobj.getCustomerName());
			ps.setString(2, contactobj.getCustomerEmail());
			ps.setString(3, contactobj.getCustomerContact());
			ps.setString(4, contactobj.getCustomerFeedback());
			System.out.println(ps);
			int i=ps.executeUpdate();
			if (i>0){
				return true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

}
