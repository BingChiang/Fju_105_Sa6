package fju.im.sa6.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
//@SessionAttributes("newaccount")

public class pageController {
	static StaffDefault newaccount = new Staff(6,"allen",0,null, 0);

	static Cart shoppingCart;

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexLoginpage() {
		System.out.print("1234567898765432");
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
//	@RequestMapping(value = "/productSale", method = RequestMethod.GET)
//	public ModelAndView productSale() {
//		ModelAndView model = new ModelAndView("redirect:productSale");
//		// ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
//		// TypeDAO typeDAO = (TypeDAO) context.getBean("TypeDAO");
//		// ArrayList<Product> typeProList = null;
//		// ArrayList<Type> typeList = null;
//		//
//		// typeList = typeDAO.getList();
//		model.addObject("typeNum", 1);
//
//		return model;
//	}
//
//	@RequestMapping(value = "/productSale", method = RequestMethod.GET)
//	public ModelAndView productSale(int typeNum) {
//		ModelAndView model = new ModelAndView("productSale");
//		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
//		TypeDAO typeDAO = (TypeDAO) context.getBean("TypeDAO");
//		ArrayList<Product> typeProList = null;
//		ArrayList<Type> typeList = null;
//
//		typeList = typeDAO.getList();
//
//		Type temp = null;
//
//		temp = new Type(null, typeNum);
//		typeProList = productDAO.getTypeList(temp);
//
//		model.addObject("typeList", typeList);
//		model.addObject("typeProList", typeProList);
//
//		List<Product> content = shoppingCart.getCart();
//		int cartTotal = 0;
//		cartTotal = shoppingCart.orderTotal();
//		model.addObject("cart", content);
//		model.addObject("cartTotal", cartTotal);
//		
//		return model;
//	}
//	
	@RequestMapping(value = "/cartClean", method = RequestMethod.GET)
	public ModelAndView cartClean() {
		ModelAndView model = new ModelAndView("redirect:productSale");
		shoppingCart.clean();
		// ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		// TypeDAO typeDAO = (TypeDAO) context.getBean("TypeDAO");
		// ArrayList<Product> typeProList = null;
		// ArrayList<Type> typeList = null;
		//
		// typeList = typeDAO.getList();
		model.addObject("typeNum", 1);

		return model;
	}

	@RequestMapping(value = "/inventoryManage", method = RequestMethod.GET)
	public ModelAndView inventoryManage() {
		ModelAndView model = new ModelAndView("inventoryManage");
		InventoryDAO inventoryDAO = (InventoryDAO) context.getBean("InventoryDAO");
		ArrayList<Inventory> invList = null;
		invList = inventoryDAO.getList();
		model.addObject("inventoryList", invList);
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

	@RequestMapping(value = "/showOrder", method = RequestMethod.GET)
	public ModelAndView showOrder() {
		ModelAndView model = new ModelAndView("showOrder");
		OrderListDAO orderListDAO = (OrderListDAO) context.getBean("OrderListDAO");
		ArrayList<OrderList> orderList = null;
		orderList = orderListDAO.getList();
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

		// DAO ERROR

		return model;
	}
	
	@RequestMapping(value = "/amendWork", method = RequestMethod.GET)
	public ModelAndView amendWork() {
		ModelAndView model = new ModelAndView("amendWork");

		return model;
	}

	@RequestMapping(value = "/managePage", method = RequestMethod.GET)
	public ModelAndView managePage() {
		ModelAndView model = new ModelAndView("managePage");

		return model;
	}

	@RequestMapping(value = "/staffManage", method = RequestMethod.GET)
	public ModelAndView staffManage() {
		ModelAndView model = new ModelAndView("staffManage");
		ArrayList<StaffDefault> staffList = null;
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		staffList = staffDefaultDAO.getList();
		model.addObject("staffList", staffList);

		return model;
	}
	
	@RequestMapping(value = "/showMonth", method = RequestMethod.GET)
	public ModelAndView showMonth(Date searchTime) {
		ModelAndView model = new ModelAndView("showMonth");
		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
		double monthTotal = 0;
		monthTotal = managerDAO.monthearntotal(searchTime);
				
		model.addObject("monthTotal",monthTotal);	
		return model;
	}
	
	
	@RequestMapping(value = "/showMonth", method = RequestMethod.POST)
	public ModelAndView showMonth() {
		ModelAndView model = new ModelAndView("redirect:showMonth");
		return model;
	}
	
	

}
