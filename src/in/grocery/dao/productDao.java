package in.grocery.dao;

import java.util.List;

import in.grocery.pojo.Product;

public interface productDao {
	//operation 
	public boolean addProduct(Product prodobj);
	public boolean updateProduct(Product prodobj);
	public boolean deleteProduct(int productId);
	public List showProductList();
	public Product searchProductById(int productId);
	public List searchProductByName(String productName);
	public List searchProductByType(String productType);
	
}
