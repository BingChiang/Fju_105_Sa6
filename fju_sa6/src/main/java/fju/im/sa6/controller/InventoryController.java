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

@Controller
public class InventoryController {

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/inventory", method = RequestMethod.GET)
	public ModelAndView getProduct(@ModelAttribute Inventory inventory) {

		ModelAndView model = new ModelAndView("inventory");
		// logger.info("controller");
		InventoryDAOImpl inventoryDAO = (InventoryDAOImpl) context.getBean("inventoryDAO");
		Inventory inventory2;
		inventory2 = inventoryDAO.get(inventory);
		// logger.info(""+productList.size());
		model.addObject("inventory", inventory2);

		return model;

	}

	@RequestMapping(value = "/inventoryList", method = RequestMethod.GET)
	public ModelAndView getProductList() {

		ModelAndView model = new ModelAndView("productList");
		// logger.info("controller");
		InventoryDAOImpl inventoryDAO = (InventoryDAOImpl) context.getBean("productDAO");
		ArrayList<Inventory> inventoryList = new ArrayList<Inventory>();
		inventoryList = inventoryDAO.getList();
		// logger.info(""+productList.size());
		model.addObject("inventoryList", inventoryList);

		return model;

	}

}
