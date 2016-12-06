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

import fju.im.sa6.dao.impl.InventoryDAOImpl;
import fju.im.sa6.dao.impl.ProductDAOImpl;
import fju.im.sa6.entity.Inventory;
import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.PurchaseList;

@Controller
public class InventoryController {

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/inventoryorder", method = RequestMethod.GET)
	public ModelAndView getInventoryList() {
		ArrayList<Inventory> inventory2 = new ArrayList<Inventory>();
		ModelAndView model = new ModelAndView("redirect:/inventoryorder");
		InventoryDAOImpl inventoryDAO = (InventoryDAOImpl) context.getBean("InventoryDAO");
		inventory2 = inventoryDAO.getList();
		model.addObject("inventoryList", inventory2);

		return model;

	}

	static Inventory tempInv = null;
	static PurchaseList purchaseList = null;

	@RequestMapping(value = "/inventoryorderchange", method = RequestMethod.POST)
	public ModelAndView postinventorytochange(@ModelAttribute 	PurchaseList purchaseList) {
		PurchaseList purchaseList2 = null;
		ModelAndView model = new ModelAndView("redirect:/inventoryorderchange");
		PurchaseListDAOImpl purchaseListDAO = (PurchaseListDAOImpl) context.getBean("PurchaseListDAO");
		purchaseList2 = inventoryDAO.get(inventory);
		tempInv = inventory2;
		// model.addObject("inventory", inventory);
		
		return model;

	}

	@RequestMapping(value = "/inventoryorderchange", method = RequestMethod.POST)
	public ModelAndView getProductList() {
		Inventory inventory2 = null;
		if (tempInv == null) {
			inventory2 = new Inventory();
		} else {
			inventory2 = tempInv;
		}
		ModelAndView model = new ModelAndView("redirect:/inventoryorderchange");
		InventoryDAOImpl inventoryDAO = (InventoryDAOImpl) context.getBean("InventoryDAO");
		model.addObject("inventoryorder", inventory2);

		return model;

	}

	


	@RequestMapping(value = "/inventoryorderremove", method = RequestMethod.POST)
	public ModelAndView postinventorytoremove(@ModelAttribute Inventory inventory) {
		Inventory inventory2 = null;
		if (tempInv == null) {
			inventory2 = new Inventory();
		} else {
			inventory2 = tempInv;
		}
		ModelAndView model = new ModelAndView("redirect:/inventoryorder");
		InventoryDAOImpl inventoryDAO = (InventoryDAOImpl) context.getBean("InventoryDAO");
		inventoryDAO.remove(inventory2);
		return model;

	}
	
	@RequestMapping(value = "/inventoryorderadd", method = RequestMethod.POST)
	public ModelAndView postinventorytoadd(@ModelAttribute Inventory inventory) {
		ModelAndView model = new ModelAndView("redirect:/inventoryorder");
		InventoryDAOImpl inventoryDAO = (InventoryDAOImpl) context.getBean("InventoryDAO");
		inventoryDAO.add(inventory);
		return model;

	}

	@RequestMapping(value = "/inventoryleft", method = RequestMethod.GET)
	public ModelAndView getInventoryListLeft() {
		ArrayList<Inventory> inventory2 = new ArrayList<Inventory>();
		ModelAndView model = new ModelAndView("");
		InventoryDAOImpl inventoryDAO = (InventoryDAOImpl) context.getBean("InventoryDAO");
		inventory2 = inventoryDAO.getList();
		model.addObject("inventoryList", inventory2);
		return model;

	}
	
	@RequestMapping(value = "/inventoryleftchange", method = RequestMethod.POST)
	public ModelAndView postinventorytoleftchange(@ModelAttribute Inventory inventory) {
		Inventory inventory2 = null;
		if (tempInv == null) {
			inventory2 = new Inventory();
		} else {
			inventory2 = tempInv;
		}
		ModelAndView model = new ModelAndView("redirect:/inventoryorder");
		InventoryDAOImpl inventoryDAO = (InventoryDAOImpl) context.getBean("InventoryDAO");
		inventoryDAO.remove(inventory2);
		return model;

	}
	
}
