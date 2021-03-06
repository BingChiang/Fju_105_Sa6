
package fju.im.sa6.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import fju.im.sa6.dao.ManagerDAO;
import fju.im.sa6.dao.OrderListDAO;
import fju.im.sa6.dao.ProductDAO;
import fju.im.sa6.dao.StaffDefaultDAO;
import fju.im.sa6.dao.SupplierDAO;
import fju.im.sa6.dao.TypeDAO;
import fju.im.sa6.dao.WorktimeDAO;
import fju.im.sa6.entity.Cart;
import fju.im.sa6.entity.Inventory;
import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.Staff;
import fju.im.sa6.entity.StaffDefault;
import fju.im.sa6.entity.Supplier;
import fju.im.sa6.entity.Type;

@Controller
@SessionAttributes("newaccount")

public class pageController {
	// StaffDefault newaccount = new Staff(6, "allen", 0, null, 0);

	static Cart shoppingCart = new Cart();

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexLoginpage() {
		// System.out.print("1234567898765432");
		ModelAndView model = new ModelAndView("index");
		ArrayList<StaffDefault> staffList = null;
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		staffList = staffDefaultDAO.getList();
		model.addObject("staffList", staffList);
		return model;
	}

	@RequestMapping(value = "/mainpage", method = RequestMethod.GET)
	public ModelAndView mainpage() {
		ModelAndView model = new ModelAndView("mainpage");

		return model;
	}

	// *****
	// @RequestMapping(value = "/productSale", method = RequestMethod.GET)
	// public ModelAndView productSale() {
	// ModelAndView model = new ModelAndView("redirect:productSale");
	// // ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
	// // TypeDAO typeDAO = (TypeDAO) context.getBean("TypeDAO");
	// // ArrayList<Product> typeProList = null;
	// // ArrayList<Type> typeList = null;
	// //
	// // typeList = typeDAO.getList();
	//
	// return model;
	// }

	@RequestMapping(value = "/inventoryManage", method = RequestMethod.GET)
	public ModelAndView inventoryManage() {
		ModelAndView model = new ModelAndView("inventoryManage");
		InventoryDAO inventoryDAO = (InventoryDAO) context.getBean("InventoryDAO");
		ArrayList<Inventory> invList = null;
		invList = inventoryDAO.getList();
		System.out.println(invList.get(invList.size() - 1).getUpdateDate());
		model.addObject("inventoryList", invList);
		return model;
	}

	@RequestMapping(value = "/supplierManage", method = RequestMethod.GET)
	public ModelAndView supplierManage() {
		ModelAndView model = new ModelAndView("supplierManage");
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("SupplierDAO");
		ArrayList<Supplier> supList = null;
		supList = supplierDAO.getList();
		System.out.println(supList.get(0).getSupplierName());
		System.out.println(supList.get(0).getSupplierAddress());
		System.out.println(supList.get(0).getSupplierPhone());

		model.addObject("supplierList", supList);
		return model;
	}

	@RequestMapping(value = "/productManage", method = RequestMethod.GET)
	public ModelAndView productManage() {
		ModelAndView model = new ModelAndView("productManage");
		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		ArrayList<Product> proList = null;
		proList = productDAO.getList();
		model.addObject("productList", proList);
		return model;
	}

	@RequestMapping(value = "/productTypeManage", method = RequestMethod.GET)
	public ModelAndView productTypeManage() {
		ModelAndView model = new ModelAndView("productTypeManage");
		TypeDAO typeDAO = (TypeDAO) context.getBean("TypeDAO");
		ArrayList<Type> typeList = null;
		typeList = typeDAO.getList();
		model.addObject("typeList", typeList);
		return model;
	}

	@RequestMapping(value = "/showOrder", method = RequestMethod.GET)
	public ModelAndView showOrder() {
		ModelAndView model = new ModelAndView("showOrder");
		OrderListDAO orderListDAO = (OrderListDAO) context.getBean("OrderListDAO");
		ArrayList<OrderList> orderList = null;
		orderList = orderListDAO.getorderlist();
		model.addObject("orderList", orderList);

		return model;
	}

	@RequestMapping(value = "/suplierManage", method = RequestMethod.GET)
	public ModelAndView suplierManage() {
		ModelAndView model = new ModelAndView("suplierManage");
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("SupplierDAO");
		ArrayList<Supplier> supplierList = null;
		supplierList = supplierDAO.getList();
		model.addObject("supplierList", supplierList);

		return model;
	}

	@RequestMapping(value = "/worktimeSearch", method = RequestMethod.GET)
	public ModelAndView worktimeSearch() {
		ModelAndView model = new ModelAndView("worktimeSearch");

		return model;
	}

	@RequestMapping(value = "/worktimeSearch", method = RequestMethod.POST)
	public ModelAndView worktimeSearch(@ModelAttribute("searchTime") Date searchTime, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("redirect:worktimeSearch");

		// DAO ERROR
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");

		return model;
	}

}
