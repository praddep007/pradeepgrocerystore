package in.grocery.pojo;

public class Cart {
	private int cartId;
	private int productId;
	private String productName;
	private double productPrice;
	private String productType;
	private int productQuantity;
	private String customerEmail;
	
	
	public Cart() {
		super();
	}


	public Cart(int cartId, int productId, String productName, double productPrice, String productType,
			int productQuantity, String customerEmail) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productType = productType;
		this.productQuantity = productQuantity;
		this.customerEmail = customerEmail;
	}


	public Cart(int productId, String productName, double productPrice, String productType, int productQuantity,
			String customerEmail) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productType = productType;
		this.productQuantity = productQuantity;
		this.customerEmail = customerEmail;
	}
	
	
	public Cart(int productId, int productQuantity, String customerEmail) {
		super();
		this.productId = productId;
		this.productQuantity = productQuantity;
		this.customerEmail = customerEmail;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
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


	public int getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", productId=" + productId + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productType=" + productType + ", productQuantity="
				+ productQuantity + ", customerEmail=" + customerEmail + "]";
	}


	

}
/*
mysql> create table cart
-(cartid int primary key auto_increment,
-> productid int not null,
-> productquantity int not null default 1,
-> customeremail varchar(100) not null);
Query OK, 0 rows affected (1.24 sec)

mysql> select p.productid,productname,productprice,producttype,customeremail,productquantity from product p inner join cart c on p.productid=c.productid;
*/