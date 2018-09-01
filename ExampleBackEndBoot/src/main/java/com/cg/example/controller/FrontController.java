package com.cg.example.controller;

import java.sql.Date;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.example.beans.DiscountBean;

@RestController
public class FrontController {

	@RequestMapping("/")
	public String consume(){
		return "REST Consumer";
	}
	/*public ModelMap showWel(Integer d) {
		return null;
		
	}*/
	
	@RequestMapping(value="/wel")
	public ModelMap showWelcomePage(String id, ModelMap model){
		
		RestTemplate restTemplate = new RestTemplate();
		DiscountBean discount = restTemplate.getForObject("http://localhost:9090/getbyDiscountId?discountId="+id, DiscountBean.class);
		System.out.println(discount);
		model.put("discount", discount);
		return model;
	}
	
	@RequestMapping(value="/discountadd")
	public DiscountBean consumeMessage(){
		DiscountBean discount=new DiscountBean();
		discount.setDiscountId("DS70");
		discount.setDiscountPercent(70);
		discount.setTimePeriod(Date.valueOf("2018-09-03"));
		RestTemplate restTemplate = new RestTemplate();
		DiscountBean discount1 = restTemplate.postForObject("http://localhost:9090/adddiscount",discount, DiscountBean.class);
		return discount1;
	}
	
	@RequestMapping(value="/viewByid")
	public DiscountBean viewByDiscountId(){
		RestTemplate restTemplate = new RestTemplate();
		DiscountBean message = restTemplate.getForObject("http://localhost:9090/getbyDiscountId?discountId=DS50", DiscountBean.class);
		
		
		return message;
	}
	/*@RequestMapping(value="/quote")
	public Quote consumeQuote(){
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		
		return quote;
	}
	
	@RequestMapping(value="/message")
	public Message consumeMessage(){
		RestTemplate restTemplate = new RestTemplate();
		Message message = restTemplate.getForObject("http://localhost:9090/getmessage?id=13", Message.class);
		
		
		return message;
	}
	
	@RequestMapping(value="/send")
	public Message sendMessage(){
		Message m = new Message();
		m.setText("Java client Posting message");
		m.setSender(new Sender("Java Client"));
		System.out.println(m);
		RestTemplate restTemplate = new RestTemplate();
		Message message = restTemplate.postForObject("http://localhost:9090/receive",m, Message.class);
		
		return message;
	}*/
	
}
