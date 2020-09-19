package dao;

import java.util.List;

import model.MyCart;
import model.Product;

public interface ProductCartDao {
	
	public void addCart(MyCart cart);
	public MyCart getCartById(int cartId);
	public Product getProductById(int prodId);
	public List<MyCart> myCart();
	public void updateCart(MyCart cd);
	public void removeCart(int cartId);

}
