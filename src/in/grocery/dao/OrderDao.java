package in.grocery.dao;

import java.util.List;

import in.grocery.pojo.Order;

public interface OrderDao {

	Order placeOrder(String customeremail);
	List<Order> getAllOrder();
	List<Order> getAllMyOrder(String customeremail);
	boolean cancelOrder(int orderid);
}





























// for totalbill of add cart product
/*
select sum(p.productprice*c.productquantity)
 from product p inner join cart c
 on p.productid=c.productid
 where customeremail='pratham123@gmail.com'
*/