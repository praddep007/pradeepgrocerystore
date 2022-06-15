package in.grocery.pojo;

public class Order {

	private int orderId;
	private double totalBill;
	private String customerEmail;
	private String orderDate;
	private String orderStatus;
	
	//constructor without any fields
	public Order() {
		super();
	}
	
	//constructor with all fields
	public Order(int orderId, double totalBill, String customerEmail, String orderDate, String orderStatus) {
		super();
		this.orderId = orderId;
		this.totalBill = totalBill;
		this.customerEmail = customerEmail;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}

 //constructor without oderId fields
	public Order(double totalBill, String customerEmail, String orderDate, String orderStatus) {
		super();
		this.totalBill = totalBill;
		this.customerEmail = customerEmail;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}


	//getter setter
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	//tostring
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", totalBill=" + totalBill + ", customerEmail=" + customerEmail
				+ ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + "]";
	}
	
	
}

