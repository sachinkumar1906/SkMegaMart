package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import model.Variety;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SessionFactory sessFactory;
	
	public SessionFactory getsessFactory()
	{
		return sessFactory;
	}
	

	

	public void setSessFactory(SessionFactory sessFactory) {
		this.sessFactory = sessFactory;
	}


	@Override
	public void addCategory(Variety var) {
		Session session = sessFactory.getCurrentSession();
		System.out.println(var.getCatId()+"\t"+var.getCatName());
		session.save(var);
		System.out.println("Record has been inserted");
		
	}




	@Override
	public List<Variety> allCategory() {
		Session session = sessFactory.getCurrentSession();
		List<Variety> catList = session.createQuery("from Variety").list();
		return catList;
	}


	@Override
	public Variety getCatById(int catId) {
		Session session = sessFactory.getCurrentSession();
		Variety var = (Variety) session.get(Variety.class, new Integer(catId));
		System.out.println("Category retrieved successfully...Visit Again..");
		return var;
	}


	@Override
	public void updateCategory(Variety var) {
		Session session = sessFactory.getCurrentSession();
		session.saveOrUpdate(var);
		System.out.println("Product updated successfully..Product detail are : "+var);
		
	}




	@Override
	public void removeCategory(int catId) {
		Session session = sessFactory.getCurrentSession();
		Variety v = (Variety) session.load(Variety.class, new Integer(catId));
		
		if(null != v)
		{
			session.delete(v);
		}
		System.out.println("Category deleted successfully"+v);
		
	}




	




	
}
