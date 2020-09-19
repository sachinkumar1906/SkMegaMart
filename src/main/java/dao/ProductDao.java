package dao;

import java.util.List;

import model.Product;


public interface ProductDao {
	public void addProduct(Product ob);
	public Product getProductById(int prodId);
	public List<Product> allProducts();
	public void updateProduct(Product ob);
	public void removeProduct(int prodId);
	
	
	
	
}


