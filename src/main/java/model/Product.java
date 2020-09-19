package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Product implements Serializable{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
  @GeneratedValue
 private int prodId;
  
  @Column(name = "Product_Name")
  @Size(min=4 , max=20 , message = "name must have atleast 4 characters")
 private String prodName;
  
  @Column(name = "Product_Desciption")
  @Size(min=4 , max=20 , message = "des must have atleast 4 characters")
 private String prodDesc;
  
  @Column(name = "Product_Price")
 private int prodPrice;
  
  @Column(name = "Product_Quantity")
 private int prodQty;
public int getProdId() {
	return prodId;
}
public void setProdId(int prodId) {
	this.prodId = prodId;
}
public String getProdName() {
	return prodName;
}
public void setProdName(String prodName) {
	this.prodName = prodName;
}
public String getProdDesc() {
	return prodDesc;
}
public void setProdDesc(String prodDesc) {
	this.prodDesc = prodDesc;
}
public int getProdPrice() {
	return prodPrice;
}
public void setProdPrice(int prodPrice) {
	this.prodPrice = prodPrice;
}
public int getProdQty() {
	return prodQty;
}
public void setProdQty(int prodQty) {
	this.prodQty = prodQty;
}


public Product() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodDesc=" + prodDesc + ", prodPrice="
			+ prodPrice + ", prodQty=" + prodQty + "]";
}

 
}
