package in.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.grocery.dbconnection.DBConnect;
import in.grocery.pojo.Customer;
import in.grocery.pojo.Product;

public class CustomerDaoImpl implements CustomerDao{
	Connection conn=null;
	PreparedStatement ps=null;
	Customer custobj=null;
	ResultSet rs=null;
	Customer cobj=null;
	
	@Override
	public boolean addCustomer(Customer custobj) {
		try{
			System.out.println("inside dao add customer");
			conn=DBConnect.getConnection();
			System.out.println("inside Database Conn");
			String sql="insert into customer1(customername,customeremail,customerpassword,customercontact,customeraddress)values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,custobj.getCustomerName());
			ps.setString(2,custobj.getCustomerEmail());
			ps.setString(3,custobj.getCustomerPassword());
			ps.setString(4,custobj.getCustomerContact());
			ps.setString(5,custobj.getCustomerAddress());
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

	@Override
	public boolean updateCustomer(Customer custobj) {
		try{
			System.out.println("inside dao update customer");
			conn=DBConnect.getConnection();
			System.out.println("inside connec");
			String sql="update customer1 set customername=?,customeremail=?,customerpassword=?,customercontact=?, customeraddress=? where customerid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,custobj.getCustomerName());
			ps.setString(2,custobj.getCustomerEmail());
			ps.setString(3,custobj.getCustomerPassword());
			ps.setString(4,custobj.getCustomerContact());
			ps.setString(5,custobj.getCustomerAddress());;
			ps.setInt(6,custobj.getCustomerId());
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

	@Override
	public boolean deleteCustomer(int customerId) {
		try{
			System.out.println("inside dao delete customer");
		
		conn=DBConnect.getConnection();
		String sql="delete from customer1 where customerid=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, customerId);
		System.out.println(ps);
		int i=ps.executeUpdate();
		if(i>0) {
			return true;
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List showCustomerList() {
		try {
			List customerlist=new ArrayList<>();
			System.out.println("inside list of customer");
			conn=DBConnect.getConnection();
			String sql="select * from customer1" ;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				cobj=new Customer();
				cobj.setCustomerId(rs.getInt(1));
				cobj.setCustomerName(rs.getString(2));
				cobj.setCustomerEmail(rs.getString(3));
				cobj.setCustomerPassword(rs.getString(4));
				cobj.setCustomerContact(rs.getString(5));
				cobj.setCustomerAddress(rs.getString(6));
				customerlist.add(cobj);
			}
			return customerlist;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public Customer searchCustomerById(int customerId) {
		try {
		
			System.out.println("inside list of customer");
			conn=DBConnect.getConnection();
			String sql="select * from customer1 where customerid=?" ;
			ps=conn.prepareStatement(sql);
			ps.setInt(1, customerId);
			rs=ps.executeQuery();
			while(rs.next()) {
				cobj=new Customer();
				cobj.setCustomerId(rs.getInt(1));
				cobj.setCustomerName(rs.getString(2));
				cobj.setCustomerEmail(rs.getString(3));
				cobj.setCustomerPassword(rs.getString(4));
				cobj.setCustomerContact(rs.getString(5));
				cobj.setCustomerAddress(rs.getString(6));
			}
			return cobj;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List searchCustomerByEmail(String customerEmail) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
