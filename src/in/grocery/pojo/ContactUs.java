package in.grocery.pojo;

public class ContactUs {
	private String customerName;
	private String customerEmail;
	private String customerContact;
	private String customerFeedback;
	
	public ContactUs() {
		super();
	}
	public ContactUs(String customerName, String customerEmail, String customerContact, String customerFeedback) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerContact = customerContact;
		this.customerFeedback = customerFeedback;
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
	public String getCustomerContact() {
		return customerContact;
	}
	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	public String getCustomerFeedback() {
		return customerFeedback;
	}
	public void setCustomerFeedback(String customerFeedback) {
		this.customerFeedback = customerFeedback;
	}
	@Override
	public String toString() {
		return "ContactUs [customerName=" + customerName + ", customerEmail=" + customerEmail + ", customerContact="
				+ customerContact + ", customerFeedback=" + customerFeedback + "]";
	}
	
	

}

/*
mysql> 
     
     create table contactus
     (customername varchar(20) not null,
     customeremail varchar(50) not null,
     customercontact varchar(12) not null,
     customerfeedback varchar(255) not null);

*/


