package in.grocery.dao;

public interface LoginDao {

	public boolean adminLogin(String email,String pass);
	public boolean customerLogin(String email, String pass);
	public boolean adminChangePassword(String email,String newpass);
	public boolean forgetPassword(String email, String newpass);
}
