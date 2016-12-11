package fju.im.sa6.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import fju.im.sa6.dao.InventoryDAO;
import fju.im.sa6.dao.SupplierDAO;
import fju.im.sa6.dao.impl.InventoryDAOImpl;
import fju.im.sa6.dao.impl.ProductDAOImpl;
import fju.im.sa6.dao.impl.SupplierDAOImpl;
import fju.im.sa6.entity.Inventory;
import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.PurchaseList;
import fju.im.sa6.entity.Supplier;

@Controller
public class InventoryController {

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/inventoryorder", method = RequestMethod.GET)
	public ModelAndView getInventoryList() {
		ArrayList<Inventory> inventory2 = new ArrayList<Inventory>();
		ModelAndView model = new ModelAndView("redirect:/inventoryorder");
		InventoryDAO inventoryDAO = (InventoryDAO) context.getBean("InventoryDAO");
		inventory2 = inventoryDAO.getList();
		model.addObject("inventoryList", inventory2);

		return model;

	}

	static Inventory tempInv = null;
	static PurchaseList purchaseList = null;

	@RequestMapping(value = "/invertoryAdd", method = RequestMethod.GET)
	public ModelAndView inventoryAddPage() {
		ModelAndView model = new ModelAndView("invertoryAdd");
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("SupplierDAO");
		ArrayList<Supplier> supplierList = null;
		supplierList = supplierDAO.getList();
		model.addObject("supplierList", supplierList);
		return model;

	}

	@RequestMapping(value = "/invertoryAdd", method = RequestMethod.POST)
	public ModelAndView addNewInv(@ModelAttribute Inventory inv) {
		ModelAndView model = new ModelAndView("redirect:/inventoryManage");
		InventoryDAO inventoryDAO = (InventoryDAO) context.getBean("InventoryDAO");
		inventoryDAO.add(inv);

		return model;

	}
	
	@RequestMapping(value = "/invertoryModify", method = RequestMethod.GET)
	public ModelAndView invertoryModifyPage(@ModelAttribute("inventoryNum") int inventoryNum,HttpServletRequest request) {
		ModelAndView model = new ModelAndView("invertoryModify");
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("SupplierDAO");
		ArrayList<Supplier> supplierList = null;
		supplierList = supplierDAO.getList();
		
		Inventory temp = new Inventory(inventoryNum,0,0,null,null,0,null);
		InventoryDAO inventoryDAO = (InventoryDAO) context.getBean("InventoryDAO");
		Inventory inv2 = inventoryDAO.get(temp);
//		inventoryDAO.add(inv2);
		model.addObject("inventory",inv2);
		model.addObject("supplierList", supplierList);
		return model;

	}
	
	@RequestMapping(value = "/inventoryModify", method = RequestMethod.POST)
	public ModelAndView invertoryModify(@ModelAttribute Inventory inv) {
		ModelAndView model = new ModelAndView("redirect:/inventoryManage");
		InventoryDAO inventoryDAO = (InventoryDAO) context.getBean("InventoryDAO");
		inventoryDAO.add(inv);

		return model;

	}
	
	

	
	@RequestMapping(value = "/supplierModify", method = RequestMethod.GET)
	public ModelAndView supplierModifyPage(@ModelAttribute("supplierNum") int supplierNum,HttpServletRequest request ) {
		ModelAndView model = new ModelAndView("supplierModify");
		Supplier temp = new Supplier(supplierNum,null,null,null,0);
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("SupplierDAO");
		Supplier sup = supplierDAO.get(temp);
		model.addObject("supplier",sup);

		return model;

	}
	
	@RequestMapping(value = "/supplierModify", method = RequestMethod.POST)
	public ModelAndView supplierModify(@ModelAttribute Supplier sup) {
		ModelAndView model = new ModelAndView("redirect:/supplierManage");
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("SupplierDAO");
		supplierDAO.add(sup);

		return model;

	}
	
	@RequestMapping(value = "/supplierAdd", method = RequestMethod.GET)
	public ModelAndView supplierAdd() {
		ModelAndView model = new ModelAndView("supplierAdd");

		return model;

	}
	
	
	
	@RequestMapping(value = "/supplierAdd", method = RequestMethod.POST)
	public ModelAndView addNewSupplier(@ModelAttribute Supplier sup) {
		ModelAndView model = new ModelAndView("redirect:/supplierManage");
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("SupplierDAO");
		supplierDAO.add(sup);

		return model;

	}
	
	@RequestMapping(value = "/showSupplier", method = RequestMethod.GET)
	public ModelAndView showSupplier(@ModelAttribute("supplierNum") int supplierNum,HttpServletRequest request  ) {
		ModelAndView model = new ModelAndView("showSupplier");
		Supplier sup = new Supplier(supplierNum,null,null,null,0);
		ArrayList<Inventory> temp = null;
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("SupplierDAO");
		InventoryDAO inventoryDAO = (InventoryDAO) context.getBean("InventoryDAO");
		temp=inventoryDAO.getList(sup);
		
		model.addObject("supplier",sup);
		model.addObject("invList",temp);
		return model;

	}
	
	
}
