package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class MyCart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	
	@Column
	private int prodId;
	
	@Column(name = "Product_Name")
	 private String productName;
	
	@Column(name = "Quantity_Purchased")
	private int qtyPurchased;
	
	@Column(name = "Product_Price")
	private int prodPrice;
	
	@Column(name = "Total")
	private int grandTotal;
	
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQtyPurchased() {
		return qtyPurchased;
	}
	public void setQtyPurchased(int qtyPurchased) {
		this.qtyPurchased = qtyPurchased;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public int getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public MyCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MyCart [cartId=" + cartId + ", prodId=" + prodId + ", productName=" + productName + ", qtyPurchased="
				+ qtyPurchased + ", prodPrice=" + prodPrice + ", grandTotal=" + grandTotal + "]";
	}
	
	
	

}
