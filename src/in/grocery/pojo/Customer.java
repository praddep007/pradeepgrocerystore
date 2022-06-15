package in.grocery.pojo;

public class Customer {
	private  int customerId;
	private String customerName;
	private String customerEmail;
	private String customerPassword;
	private String customerConfirmPassword;
	private String customerContact;
	private String customerAddress;
	
	public Customer() {
		super();
	}

	


	

	public Customer(int customerId, String customerName, String customerEmail, String customerPassword,
			String customerConfirmPassword, String customerContact, String customerAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerConfirmPassword = customerConfirmPassword;
		this.customerContact = customerContact;
		this.customerAddress = customerAddress;
	}

    //with all fields
	public Customer(String customerName, String customerEmail, String customerPassword, String customerConfirmPassword,
			String customerContact, String customerAddress) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerConfirmPassword = customerConfirmPassword;
		this.customerContact = customerContact;
		this.customerAddress = customerAddress;
	}


   //without customerconfirmpassword fields
	public Customer(int customerId, String customerName, String customerEmail, String customerPassword,
			String customerContact, String customerAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerContact = customerContact;
		this.customerAddress = customerAddress;
	}


  //without customerid and customerconfirmpassword fields
	public Customer(String customerName, String customerEmail, String customerPassword, String customerContact,
			String customerAddress) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerContact = customerContact;
		this.customerAddress = customerAddress;
	}







	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerConfirmPassword() {
		return customerConfirmPassword;
	}

	public void setCustomerConfirmPassword(String customerConfirmPassword) {
		this.customerConfirmPassword = customerConfirmPassword;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}


	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}






	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerPassword=" + customerPassword + ", customerConfirmPassword="
				+ customerConfirmPassword + ", customerContact=" + customerContact + ", customerAddress="
				+ customerAddress + "]";
	}
}
