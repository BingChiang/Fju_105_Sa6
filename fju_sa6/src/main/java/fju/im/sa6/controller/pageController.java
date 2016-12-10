package fju.im.sa6.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fju.im.sa6.dao.InventoryDAO;
import fju.im.sa6.dao.OrderListDAO;
import fju.im.sa6.dao.ProductDAO;
import fju.im.sa6.dao.StaffDefaultDAO;
import fju.im.sa6.dao.SupplierDAO;
import fju.im.sa6.entity.Inventory;
import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.StaffDefault;
import fju.im.sa6.entity.Supplier;


@Controller
public class pageController {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public ModelAndView indexLoginpage() {
		ModelAndView model = new ModelAndView("/");
		ArrayList<StaffDefault> staffList = null;
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		staffList = staffDefaultDAO.getList();
		model.addObject("staffList", staffList);
		return model;
	}
	
	@RequestMapping(value = "/mainpage", method = RequestMethod.GET)
	public ModelAndView mainpage() {
		ModelAndView model = new ModelAndView("/mainpage");
		

		return model;
	}
	//*****
	@RequestMapping(value = "/productSale", method = RequestMethod.GET)
	public ModelAndView productSale() {
		ModelAndView model = new ModelAndView("/productSale");
		

		return model;
	}
	
	@RequestMapping(value = "/inventoryManage", method = RequestMethod.GET)
	public ModelAndView inventoryManage() {
		ModelAndView model = new ModelAndView("/inventoryManage");
		InventoryDAO inventoryDAO = (InventoryDAO) context.getBean("InventoryDAO");
		ArrayList<Inventory> invList = null;
		invList = inventoryDAO.getList();
		model.addObject("inventoryList", invList);
		return model;
	}
	
	@RequestMapping(value = "/productManage", method = RequestMethod.GET)
	public ModelAndView productManage() {
		ModelAndView model = new ModelAndView("/productManage");
		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		ArrayList<Product> proList = null;
		proList = productDAO.getList();
		model.addObject("productList", proList);
		return model;
	}
	
	
	@RequestMapping(value = "/showOrder", method = RequestMethod.GET)
	public ModelAndView showOrder() {
		ModelAndView model = new ModelAndView("/showOrder");
		OrderListDAO orderListDAO = (OrderListDAO) context.getBean("OrderListDAO");
		ArrayList<OrderList> orderList = null;
		orderList = orderListDAO.getList();
		model.addObject("orderList", orderList);

		return model;
	}

	@RequestMapping(value = "/suplierManage", method = RequestMethod.GET)
	public ModelAndView suplierManage() {
		ModelAndView model = new ModelAndView("/suplierManage");
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("SupplierDAO");
		ArrayList<Supplier> supplierList = null;
		supplierList = supplierDAO.getList();
		model.addObject("supplierList", supplierList);

		return model;
	}
	

	@RequestMapping(value = "/worktimeSearch", method = RequestMethod.GET)
	public ModelAndView worktimeSearch() {
		ModelAndView model = new ModelAndView("/worktimeSearch");
		
		//DAO ERROR
		
		
		return model;
	}
	
	@RequestMapping(value = "/managePage", method = RequestMethod.GET)
	public ModelAndView managePage() {
		ModelAndView model = new ModelAndView("/managePage");
		

		return model;
	}
	
	@RequestMapping(value = "/staffManage", method = RequestMethod.GET)
	public ModelAndView staffManage() {
		ModelAndView model = new ModelAndView("/staffManage");
		ArrayList<StaffDefault> staffList = null;
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		staffList = staffDefaultDAO.getList();
		model.addObject("staffList", staffList);
		
		return model;
	}

}
