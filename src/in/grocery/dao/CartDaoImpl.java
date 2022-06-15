package in.grocery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.grocery.dbconnection.DBConnect;
import in.grocery.pojo.Cart;
import in.grocery.pojo.Product;

public class CartDaoImpl implements CartDao{
	Connection conn=null;
	PreparedStatement ps;
	Cart cartobj=null;
	ResultSet rs=null;

	@Override
	public boolean addToCart(Cart cart) {
		try {
			System.out.println("inside dao add to Cart");
			conn=DBConnect.getConnection();
			String sql="insert into cart(productid,productquantity,customeremail)values(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cart.getProductId());
			ps.setInt(2, cart.getProductQuantity());
			ps.setString(3, cart.getCustomerEmail());
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
	public boolean removeFromCart(int cartId) {
		try
		{
			 System.out.println("Inside the dao removeFromCart ");
			conn=DBConnect.getConnection();
			String sql = "delete from cart where cartid=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cartId);
			int i = ps.executeUpdate();
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

	@Override
	public boolean clearCart(String customeremail) {
		try
		{
			System.out.println("Inside the dao clearChat ");
			conn=DBConnect.getConnection();
			String sql = "delete from cart where customeremail=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,customeremail);
			int i = ps.executeUpdate();
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

	@Override
	public List<Cart> showCart(String customeremail) {
		List<Cart> cartlist = new ArrayList<>();
		try
		{
			System.out.println("inside dao showCart");
			conn = DBConnect.getConnection();
			String sqlQuery = "Select c.cartid, c.productid, p.productname,p.productprice, p.producttype, c.productquantity, c.customeremail from cart c inner join product p ON (c.productid=p.productid) where c.customeremail = ?";
			ps=conn.prepareStatement(sqlQuery);
			ps.setString(1, customeremail);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				Cart cart = new Cart();
				cart.setCartId(rs.getInt(1));
				cart.setProductId(rs.getInt(2));
				cart.setProductName(rs.getString(3));
				cart.setProductPrice(rs.getDouble(4));
				cart.setProductType(rs.getString(5));
				cart.setProductQuantity(rs.getInt(6));
				cart.setCustomerEmail(rs.getString(7));
				
				cartlist.add(cart);
				
			}
			
		}
		
			catch(Exception e)
			{
				e.printStackTrace();
			}
	
		return cartlist;
	}
	

}
