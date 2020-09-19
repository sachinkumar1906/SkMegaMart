package dao;


import java.util.List;

import model.Variety;

public interface CategoryDao {
	
	public void addCategory(Variety var);
	public List<Variety> allCategory();
	public Variety getCatById(int catId);
	public void updateCategory(Variety var);
	public void removeCategory(int catId);

}
