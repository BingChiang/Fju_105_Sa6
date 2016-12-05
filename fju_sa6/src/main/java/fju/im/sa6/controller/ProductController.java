package fju.im.sa6.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.Type;
import fju.im.sa6.dao.ProductDAO;
import fju.im.sa6.dao.impl.ProductDAOImpl;


/**
* Handles requests for the application home page.
*/
@Controller
public class ProductController {
	//@Autowired
	//private ProductDAO productDAO;
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	
	//private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView getProduct(@ModelAttribute Product product){
	
		ModelAndView model = new ModelAndView("product");
		//logger.info("controller");
		ProductDAOImpl productDAO = (ProductDAOImpl)context.getBean("productDAO");
		Product product2;
		product2 = productDAO.get(product);
		//logger.info(""+productList.size());
		model.addObject("product", product2);
		
		return model;
		
	}
	
	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public ModelAndView getProductList(){
	
		ModelAndView model = new ModelAndView("productList");
		//logger.info("controller");
		ProductDAOImpl productDAO = (ProductDAOImpl)context.getBean("productDAO");
		ArrayList<Product> productList = new ArrayList<Product>();
		productList = productDAO.getList();
		//logger.info(""+productList.size());
		model.addObject("productList", productList);
		
		return model;
		
	}
	
	
	@RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
	public ModelAndView insertProductPage(){
		ModelAndView model = new ModelAndView("insertProduct");
		
		
		//need the following part for product category
		/*
		ArticleCategoryDAO articleCategoryDAO = (ArticleCategoryDAO)context.getBean("articleCategoryDAO");
		List<ArticleCategory> articleCategoryList = new ArrayList<ArticleCategory>();
		articleCategoryList = articleCategoryDAO.getList();
		model.addObject("articleCategoryList", articleCategoryList);
		*/
		return model;
	}
	
	@RequestMapping(value = "/Mproductadd", method = RequestMethod.POST)
	public ModelAndView insertProduct(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("redirect:/product");
		ProductDAOImpl productDAO = (ProductDAOImpl)context.getBean("productDAO");
		productDAO.add(product);
		
		return model;
	}
  

	@RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
	public ModelAndView updateProductPage(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("updateProduct");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		//will need the following part later
		/*
		ArticleCategoryDAO articleCategoryDAO = (ArticleCategoryDAO)context.getBean("articleCategoryDAO");
		List<ArticleCategory> articleCategoryList = new ArrayList<ArticleCategory>();
		articleCategoryList = articleCategoryDAO.getList();
		*/
		product = productDAO.get(product);
		//System.out.println("id="+product.getId());
		//will need the following part later
		//model.addObject("articleCategoryList", articleCategoryList);
		model.addObject("product", product);
		return model;
	}
	
	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("redirect:/product");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		productDAO.set(product);	
		return model;
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
	public ModelAndView deleteProduct(@ModelAttribute Product product){
		ModelAndView model = new ModelAndView("redirect:/product");
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		productDAO.remove(product);
		return model;
	}



	@RequestMapping(value = "/typeProduct", method = RequestMethod.GET)
	public ModelAndView listAvailableProduct(Type type){
	
		ModelAndView model = new ModelAndView("availableProduct");
		//logger.info("controller");S
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		List<Product> productList = new ArrayList<Product>();
		productList = productDAO.getTypeList(type);
		//logger.info(""+productList.size());
		model.addObject("productList", productList);
		
		return model;
	}

}
