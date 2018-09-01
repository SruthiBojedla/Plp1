package com.cg.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cg.example.beans.DiscountBean;
import com.cg.example.beans.FeedbackProductBean;
import com.cg.example.beans.ImageBean;
import com.cg.example.beans.MerchantBean;
import com.cg.example.beans.ProductBean;
import com.cg.example.beans.PromosBean;

@Controller
public class JspController {

	/*@RequestMapping(value="/welcome")
	public String showWelcomePage(String id, ModelMap model){
		
		RestTemplate restTemplate = new RestTemplate();
		DiscountBean discount = restTemplate.getForObject("http://localhost:9090/getbyDiscountId?discountId="+id, DiscountBean.class);
		System.out.println(discount);
		model.put("discountId", discount);
		return "welcome";
	}*/
	
	@RequestMapping(value="/welcome")
	public String wel() {
		return "welcome";
	}
	
	@RequestMapping("/AddProduct")
	String addProductByMerchant(HttpServletRequest request, ModelMap model) {
		String productId=request.getParameter("productId");
		String productName=request.getParameter("productName");
		String price1=request.getParameter("price");
		//Integer.getInteger(request.getParameter("myInt")).intValue();
		Double price=Double.valueOf(price1);
		//List<MerchantBean> merchant;
		Integer quantity= Integer.getInteger(request.getParameter("quantity")).intValue();
		String category=request.getParameter("category");
		/*PromosBean promoCode;
		DiscountBean discount;
		List<ImageBean> imageId;
		List<FeedbackProductBean> feedbackProduct;*/
		
		ProductBean product = new ProductBean();
		product.setProductId(productId);
		product.setProductName(productName);
		product.setPrice(price);
		product.setQuantity(quantity);
		product.setCategory(category);
		
		System.out.println(product.toString());
		RestTemplate restTemplate = new RestTemplate();
		
		String str=restTemplate.postForObject("http://localhost:9090/addProduct", product, String.class);
		/*model.put("response", "true");
		System.out.println(str);*/
		/*if(str==null) {
			model.put("response", "true");
			str="Product added Successfully";
			model.put("msg", str);
			System.out.println("str:"+str);
		}
		else {
			model.put("response", "true");
			model.put("msg", str);
			System.out.println("str:"+str);
		}*/
		model.addAttribute("product", product);
		return "AddProduct";
		
	}
	
}
