package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Variety implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int catId;
	
	@Column(name = "Category_Name")
	private String catName;
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public Variety() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Variety [catId=" + catId + ", catName=" + catName + "]";
	}
	
	

}
