package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao 
{
    
	@Autowired
	SessionFactory sessFact;

	public SessionFactory getSessionFact()
	{
		return sessFact;
	}
	
	public void setSessFact(SessionFactory sessFact) {
		this.sessFact = sessFact;
	}
	@Override
	public void addProduct(Product ob) {
		Session session = sessFact.getCurrentSession();
		System.out.println(/* ob.getProdId()+"\t"+ */ob.getProdName()+"\t"+ob.getProdPrice()+"\t"+ob.getProdQty()+"\t"+ob.getProdDesc());
		session.save(ob);
		System.out.println("Record has been inserted");
	}
	
	@Override
	public Product getProductById(int prodId)
	{
		Session session = sessFact.getCurrentSession();
		Product ob = (Product) session.load(Product.class, new Integer(prodId));
		System.out.println("Product retrieved successfully...Visit Again..");
		return ob;
	}

	@Override
	public List<Product> allProducts() {
		Session session = sessFact.openSession();
		List<Product> proList = session.createQuery("from Product").list();
		return proList;
	}

	@Override
	public void updateProduct(Product ob) {
		Session session = sessFact.getCurrentSession();
		session.saveOrUpdate(ob);
		System.out.println("Product updated successfully..Product detail are : "+ob);
		
	}

	@Override
	public void removeProduct(int prodId) {
		Session session = sessFact.getCurrentSession();
		Product p = (Product) session.load(Product.class, new Integer(prodId));
		if(null != p)
		{
			session.delete(p);
		}
		System.out.println("Product deleted successfully, product details="+p);
	}
}
