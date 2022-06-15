package in.grocery.pojo;

import java.io.InputStream;

public class Product {
	private int productId;
	private String productName;
	private double productPrice;
	private String productType;
	private double productWeight;
	private InputStream productImage;
	
	
	public Product() {
		super();
	}
	
	public Product(int productId, String productName, double productPrice, String productType, double productWeight,
			InputStream productImage) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productType = productType;
		this.productWeight = productWeight;
		this.productImage = productImage;
	}
	
	
	public Product(String productName, double productPrice, String productType, double productWeight,
			InputStream productImage) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productType = productType;
		this.productWeight = productWeight;
		this.productImage = productImage;
	}

	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public double getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(double productWeight) {
		this.productWeight = productWeight;
	}

	public InputStream getProductImage() {
		return productImage;
	}

	public void setProductImage(InputStream productImage) {
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productType=" + productType + ", productWeight=" + productWeight + ", productImage=" + productImage
				+ "]";
	}

}





/*
mysql> create database mygrocery_pradeep;
Query OK, 1 row affected (0.54 sec)

mysql> use grocery_pradeep;
Database changed
mysql> 
mysql> create table product (productid int primary key auto_increment,
    -> productname varchar(30)not null,
    -> productprice int not null,
    -> producttype varchar(50)not null,
    -> productweight int not null);
Query OK, 0 rows affected (0.99 sec)
*/
