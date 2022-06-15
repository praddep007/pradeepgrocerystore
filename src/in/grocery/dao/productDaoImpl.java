package in.grocery.dao;

import java.sql.*;
/*for adding the  image in product we used the data type is  BOLB   */  /*data type of image is BINARYSTREAM*/
import java.util.ArrayList;
import java.util.List;

import in.grocery.dbconnection.DBConnect;
import in.grocery.pojo.Product;

public class productDaoImpl implements productDao{

	Connection conn=null;
	PreparedStatement ps;
	boolean result;
	ResultSet rs=null;
	Product pobj=null;
	
	@Override
	public boolean addProduct(Product prodobj) {
		try{
			System.out.println("inside dao add product");
			conn=DBConnect.getConnection();
			String sql="insert into product(productname,productprice,producttype,productweight, productimage)values(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, prodobj.getProductName());
			ps.setDouble(2, prodobj.getProductPrice());
			ps.setString(3, prodobj.getProductType());
			ps.setDouble(4, prodobj.getProductWeight());
			ps.setBinaryStream(5, prodobj.getProductImage());
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
	public boolean updateProduct(Product prodobj) {
		try{
			System.out.println("inside dao update product");
			conn=DBConnect.getConnection();
			String sql="update product set productname=?,productprice=?,producttype=?,productweight=?, productimage=? where productid=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, prodobj.getProductName());
			ps.setDouble(2, prodobj.getProductPrice());
			ps.setString(3, prodobj.getProductType());
			ps.setDouble(4, prodobj.getProductWeight());
			ps.setBinaryStream(5, prodobj.getProductImage());
			ps.setInt(6, prodobj.getProductId());
			
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
	public boolean deleteProduct(int productId) {
		try{
			System.out.println("inside dao delete product");
		
		conn=DBConnect.getConnection();
		String sql="delete from product where productid=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, productId);
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
	public List showProductList() {
		try {
			List productlist=new ArrayList<>();
			System.out.println("inside list of product");
			conn=DBConnect.getConnection();
			String sql="select * from product" ;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				pobj=new Product();
				pobj.setProductId(rs.getInt(1));
				pobj.setProductName(rs.getString(2));
				pobj.setProductPrice(rs.getDouble(3));
				pobj.setProductType(rs.getString(4));
				pobj.setProductWeight(rs.getDouble(5));
				pobj.setProductImage(rs.getBinaryStream(6));
				productlist.add(pobj);
			}
			return productlist;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product searchProductById(int productId) {
		try {
			System.out.println("inside dao search by id product");
			conn=DBConnect.getConnection();
			String sql="select * from product where productid=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, productId);
			rs=ps.executeQuery();
			while(rs.next()) {
				pobj= new Product();
				pobj.setProductId(rs.getInt(1));
				pobj.setProductName(rs.getString(2));
				pobj.setProductPrice(rs.getDouble(3));
				pobj.setProductType(rs.getString(4));
				pobj.setProductWeight(rs.getDouble(5));
				pobj.setProductImage(rs.getBinaryStream(6));
				return pobj;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List searchProductByName(String productName) {
		try{
			List productlist=new ArrayList<>();
			System.out.println("inside search product by name");
			conn=DBConnect.getConnection();
			String sql="select *from product where productname=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, productName);
			rs=ps.executeQuery();//3
			while(rs.next()){
				//we are fetching details by using rs object and storing all columns in pobj
				pobj=new Product();
				pobj.setProductId(rs.getInt(1));
				pobj.setProductName(rs.getString(2));
				pobj.setProductPrice(rs.getDouble(3));
				pobj.setProductType(rs.getString(4));
				pobj.setProductWeight(rs.getDouble(5));
				pobj.setProductImage(rs.getBinaryStream(6));
				productlist.add(pobj);
			}
			return productlist;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List searchProductByType(String productType) {
		try{
			List productlist=new ArrayList<>();
			System.out.println("inside search product by type");
			conn=DBConnect.getConnection();
			String sql="select *from product where producttype=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, productType);
			rs=ps.executeQuery();//3
			while(rs.next()){
				//we are fetching details by using rs object and storing all columns in pobj
				pobj=new Product();
				pobj.setProductId(rs.getInt(1));
				pobj.setProductName(rs.getString(2));
				pobj.setProductPrice(rs.getDouble(3));
				pobj.setProductType(rs.getString(4));
				pobj.setProductWeight(rs.getDouble(5));
				pobj.setProductImage(rs.getBinaryStream(6));
				productlist.add(pobj);
			}
			return productlist;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
