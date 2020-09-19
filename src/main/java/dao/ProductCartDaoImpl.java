package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import model.MyCart;
import model.Product;

public class ProductCartDaoImpl implements ProductCartDao{
	
	@Autowired
	SessionFactory sFactory;
	
	

	public SessionFactory getsFactory() {
		return sFactory;
	}

	public void setsFactory(SessionFactory sFactory) {
		this.sFactory = sFactory;
	}

	@Override
	public void addCart(MyCart cart) {
		Session sess = sFactory.openSession();
		System.out.println(cart.getProductName()+"\t"+cart.getProdId()+"\t"+cart.getProdPrice()+"\t"+cart.getQtyPurchased());
		sess.save(cart);
		System.out.println("Record has been inserted");
	}
		
	
	
	@Override
	public MyCart getCartById(int cartId) {
		Session sess = sFactory.openSession();
		MyCart cm = (MyCart) sess.load(MyCart.class, new Integer(cartId));
		System.out.println("cart is there..Thank you");
		return cm;
	}

	@Override
	public Product getProductById(int prodId) {
		Session sess = sFactory.openSession();
		Product pm = (Product) sess.load(Product.class, new Integer(prodId));
		System.out.println("Product added successfully..Thank you");
		return pm;
		
	}

	@Override
	public List<MyCart> myCart() {
		Session sess = sFactory.openSession();
		List<MyCart> cartList = sess.createQuery("from MyCart").list();
		return cartList;
	}

	@Override
	public void updateCart(MyCart cd) {
		Session sess = sFactory.openSession();
		sess.saveOrUpdate(cd);
		System.out.println("Cart updated successfully");
		
	}

	@Override
	public void removeCart(int cartId) {
		Session sess = sFactory.openSession();
		
		MyCart c = (MyCart) sess.load(MyCart.class, new Integer(cartId));
		if(null != c)
		{
			sess.delete(c);
		}
		System.out.println("Product deleted successfully, product details="+c);
		
	}

	

}
