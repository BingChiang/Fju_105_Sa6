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

import fju.im.sa6.entity.Inventory;
import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.Staff;
import fju.im.sa6.entity.StaffDefault;
import fju.im.sa6.entity.Supplier;
import fju.im.sa6.entity.Type;
import fju.im.sa6.dao.InventoryDAO;
import fju.im.sa6.dao.ManagerDAO;
import fju.im.sa6.dao.OrderListDAO;
import fju.im.sa6.dao.ProductDAO;
import fju.im.sa6.dao.StaffDefaultDAO;
import fju.im.sa6.dao.SupplierDAO;
import fju.im.sa6.dao.TypeDAO;
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
	
	@RequestMapping(value = "/productTypeAdd", method = RequestMethod.POST)
	public ModelAndView productTypeAddPage(@ModelAttribute Type type) {
		ModelAndView model = new ModelAndView("redirec:productTypeManage");
		TypeDAO typeDAO = (TypeDAO) context.getBean("TypeDAO");
		typeDAO.add(type);
		return model;

	}
	
	@RequestMapping(value = "/productTypeModify", method = RequestMethod.GET)
	public ModelAndView productModify(int typeNum) {
		ModelAndView model = new ModelAndView(":productModify");
		TypeDAO typeDAO = (TypeDAO) context.getBean("TypeDAO");
		Type temp = new Type(null,typeNum);
		Type temp2 = typeDAO.getType(temp);
		model.addObject("type",temp2);
		return model;

	}

	
	@RequestMapping(value = "/productTypeModify", method = RequestMethod.POST)
	public ModelAndView productTypeModify(@ModelAttribute Type type) {
		ModelAndView model = new ModelAndView("redirec:productType");
		TypeDAO typeDAO = (TypeDAO) context.getBean("TypeDAO");
		typeDAO.add(type);
		return model;

	}
	
	@RequestMapping(value = "/productAdd", method = RequestMethod.POST)
	public ModelAndView productTypeAddPage(@ModelAttribute Product product) {
		ModelAndView model = new ModelAndView("redirec:productManage");
		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		productDAO.add(product);
		return model;

	}
	
	@RequestMapping(value = "/productModify", method = RequestMethod.GET)
	public ModelAndView invertoryModifyPage(int productNum) {
		ModelAndView model = new ModelAndView("productModify");
		TypeDAO typeDAO = (TypeDAO) context.getBean("TypeDAO");
		ArrayList<Type> typeList = null;
		typeList = typeDAO.getList();
		
		Product temp = new Product(productNum,0,null,0,0,0);
		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		Product temp2 = productDAO.get(temp);
//		inventoryDAO.add(inv2);
		model.addObject("product",temp2);
		model.addObject("typeList", typeList);
		return model;

	}

}