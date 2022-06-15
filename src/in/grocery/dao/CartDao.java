package in.grocery.dao;

import java.util.List;

import in.grocery.pojo.Cart;

public interface CartDao {
	boolean addToCart(Cart cart);
	boolean removeFromCart(int cartId);
	boolean clearCart(String customeremail);
	List<Cart> showCart(String customeremail);

}
