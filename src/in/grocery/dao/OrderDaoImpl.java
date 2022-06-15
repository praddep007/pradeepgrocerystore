package in.grocery.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.grocery.dbconnection.DBConnect;
import in.grocery.pojo.Cart;
import in.grocery.pojo.Order;

public class OrderDaoImpl implements OrderDao {
	Connection conn=null;
	PreparedStatement ps;
	Cart cartobj=null;
	ResultSet rs=null;
	int i ;

	@Override
	public Order placeOrder(String customeremail) {
		String status = "Processing";
		Date date = new Date();
		String orderdate = date.toString(); // it will converted the object of the date into the String
		double totalBill = getTotalBill(customeremail);
		try
		{
			 
			conn = DBConnect.getConnection();
			String sql = "insert into order1(totalbill,customeremail,orderdate,orderstatus) values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, totalBill);
			ps.setString(2, customeremail);
			ps.setString(3, orderdate);
			ps.setString(4, status);
			
			i = ps.executeUpdate();
			
			if(i >0)
			{
				String query="delete from cart where customeremail=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, customeremail);
				int j =ps.executeUpdate();
				String sql1 ="select * from order1 where customeremail=? and orderdate=?";
				ps  = conn.prepareStatement(sql1);
				ps.setString(1, customeremail);
				ps.setString(2, orderdate);
				
				rs = ps.executeQuery();
				
				if(rs.next())
				{
					Order order = new Order();
					order.setOrderId(rs.getInt(1));
					order.setTotalBill(rs.getDouble(2));
					order.setCustomerEmail(rs.getString(3));
					order.setOrderDate(rs.getString(4));
					order.setOrderStatus(rs.getString(5));
					
					return order;
					
			}
			}
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	
	//it created for placeOrder to Calculate the totalBill of the cart.
	public double getTotalBill(String customeremail)
	{
		try
		{
			conn = DBConnect.getConnection();
			String sql="select sum(p.productprice*c.productquantity)  from product p inner join cart c  on p.productid=c.productid  where customeremail=?";
			/*
			       EG . select sum(p.productprice*c.productquantity) from product p inner join cart c ON p.productid=c.productid where customeremail='pradeep@gmail.com';
			 */
			ps = conn.prepareStatement(sql);
			ps.setString(1, customeremail);
			
			rs = ps.executeQuery();
			if(rs.next())
			{
				return rs.getDouble(1);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return  0;
	}

	@Override
	public List<Order> getAllOrder() {
		List<Order> orderlist=new ArrayList<>();
		try {
			System.out.println("inside dao get all orders");
			conn=DBConnect.getConnection();
			String sql="select * from order1";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Order order=new Order();
				order.setOrderId(rs.getInt(1));
				order.setTotalBill(rs.getDouble(2));
				order.setCustomerEmail(rs.getString(3));
				order.setOrderDate(rs.getString(4));
				order.setOrderStatus(rs.getString(5));
				orderlist.add(order);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderlist;
	}

	@Override
	public List<Order> getAllMyOrder(String customeremail) {
		List<Order> orderlist  = new ArrayList();
		try
		{
			System.out.println("inside dao getallmyorder");
			conn = DBConnect.getConnection();
			String sql = "select * from order1 where customeremail=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, customeremail);
			rs= ps.executeQuery();
			
			while(rs.next())
		     {
				
				Order order = new Order();
				order.setOrderId(rs.getInt(1));
				order.setTotalBill(rs.getDouble(2));
				order.setCustomerEmail(rs.getString(3));
				order.setOrderDate(rs.getString(4));
				order.setOrderStatus(rs.getString(5));
				
				orderlist.add(order);
		     }
		
			
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		return orderlist;
	}

	@Override
	public boolean cancelOrder(int orderid) {
	
		try
		{
			System.out.println("inside dao of Cancel Order");
			conn = DBConnect.getConnection();
			String sql = "delete  from order1 where orderid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, orderid);
			System.out.println(ps);
			
			i = ps.executeUpdate();
			
			if(i>0)
			{
				return true;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

}
