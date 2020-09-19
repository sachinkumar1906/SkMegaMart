package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.CartDao;
import dao.CategoryDao;
import dao.ProductDao;
import model.MyCart;
import model.Product;
import model.Variety;

@Controller
public class MyController {

	@Autowired
	ProductDao pdao;
	
	@Autowired
	CategoryDao cdao;
	
	@Autowired
	CartDao cmdao;
	
	

	List<Product> proList = new ArrayList<Product>();
	List<Variety> catList = new ArrayList<Variety>();

	@RequestMapping("/")
	public String getHome() {
		return "index";
	}

	@RequestMapping("index")
	public String Home() {
		return "index";
	}

	@RequestMapping("aboutus")
	public String aboutUs() {
		return "AboutUs";
	}

	@RequestMapping("contactus")
	public String contactUs() {
		return "ContactUs";
	}

	@RequestMapping("addprod")
	public String addProducts() {
		return "AddProducts";
	}
	
	/*
	 * @RequestMapping("userproducts") public String userProduct() { return
	 * "UserProducts"; }
	 */ 
	
	@RequestMapping(value = "/userproducts", method = RequestMethod.GET)
	public String userProduct(Model mod) {
		proList = pdao.allProducts();
		mod.addAttribute("allProducts", proList);
		return "UserProducts";
	}


	@RequestMapping("signup")
	public String signUp() {
		return "SignUp";
	}

	@RequestMapping("login")
	public String login() {
		return "Login";
	}
	
	@RequestMapping("prodcat")
	public String categories()
	{
		return "AddCategory";
	}
	
	
	/*
	 * @RequestMapping("allcart") public String cartism() { return "Cart"; }
	 */
	
	 
	@RequestMapping(value = "/addprod", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("AddProducts", "product", new Product());
	}

	@RequestMapping(value = "/showProducts", method = RequestMethod.POST)
	public String showProducts(@Valid @ModelAttribute("product") Product pro , BindingResult b) {
		if(b.hasErrors())
		{
			return "AddProducts";
		}
		pdao.addProduct(pro);
		return "redirect:/allprod";
	}

	@RequestMapping(value = "/allprod", method = RequestMethod.GET)
	public String listProducts(Model model) {
		proList = pdao.allProducts();
		model.addAttribute("allProducts", proList);
		return "AllProducts";
	}

	
	
	
	 @RequestMapping(value="/update")
	  public String edit(@RequestParam("id") String id, Model model) 
	  { 
		  int proId = Integer.parseInt(id);
		  Product product = pdao.getProductById(proId);
		  System.out.println("Id = "+product.getProdId()+"\tName = "+product.getProdName());
		  model.addAttribute("pro",product);
		  return "Edit";
	  }
	  
	  @RequestMapping(value="/saveUpdatedProduct", method = RequestMethod.POST)
	  public String saveUpdatedProduct(@ModelAttribute("pro") Product product)
	  {
		  pdao.updateProduct(product);
		  return "redirect:/allprod";
	  }
	  
	  
	  
	  
	  @RequestMapping(value = "/delete")
	 public String removeProduct(@RequestParam("id") String id)
	 {
		  int proId = Integer.parseInt(id);
		  pdao.removeProduct(proId);
		  return "redirect:/allprod";
	 }
	  
	  
	/*This is for category*/
	  
	  
	  @RequestMapping(value = "/prodcat", method = RequestMethod.GET)
		public ModelAndView viewForm() {
			return new ModelAndView("AddCategory", "cat", new Variety());
		}

		@RequestMapping(value = "/showCategory", method = RequestMethod.POST)
		public String showCategories(@ModelAttribute("cat") Variety productcat) {
			cdao.addCategory(productcat);
			return "showCategory";
		}
	  
		
		@RequestMapping(value = "/allcat", method = RequestMethod.GET)
		public String listCategory(Model mod) {
			catList = cdao.allCategory();
			mod.addAttribute("allCategory", catList);
			return "AllCategories";
		}
		
		
		
		 @RequestMapping(value="/updatecat")
		  public String editCategory(@RequestParam("id") String id, Model mod) 
		  { 
			  int catId = Integer.parseInt(id);
			  Variety var = cdao.getCatById(catId);
			  System.out.println("Id = "+var.getCatId()+"\tName = "+var.getCatName());
			  mod.addAttribute("category",var);
			  return "EditCat";
		  }
		
		 
		@RequestMapping(value="/saveUpdatedCategory", method = RequestMethod.POST)
		  public String saveUpdatedCategory(@ModelAttribute("category") Variety productcat)
		  {
			  cdao.updateCategory(productcat);
			  return "redirect:/allcat";
		  }
		  
		
		
		@RequestMapping(value="/deletecat")
		 public String removeCategory(@RequestParam("id") String cid) 
		{
			int catId = Integer.parseInt(cid);
			cdao.removeCategory(catId);
			return "redirect:allcat";
		}
		
		
	/* This is for Add To Cart */
		
	
		 
		
		 @RequestMapping(value = "/addCart", method = RequestMethod.GET)
			public String viewCart(@ModelAttribute("cartdemo") MyCart ob , @RequestParam("id") int pid) {
			 Product pro = pdao.getProductById(pid);
			 
		/* System.out.println(pro.getProdName()); */
			  
			 MyCart cr = new MyCart();
			 cr.setProdId(pro.getProdId());
			 cr.setProductName(pro.getProdName());
			 cr.setProdPrice(pro.getProdPrice());
			 cr.setQtyPurchased(ob.getQtyPurchased());
			 int Total = cr.getProdPrice()*cr.getQtyPurchased();
			 cr.setGrandTotal(Total);
			 
			 
			/* */
			 cmdao.addCart(cr);
			 return "ShowCart";
			 
				
			}
		 
		 @RequestMapping(value = "/allcart")
			public String showCart(Model m) {
				List<MyCart> cr = cmdao.myCart();
				
				 m.addAttribute("cartdata",cr);
				 System.out.println(cr.toString());
				 
				 return "Cart";
				
			}
		 
		 
		 
		 
		 
		
		 
		 

	
		
		
	  
	  
	  
	
	 
}
