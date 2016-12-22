
package fju.im.sa6.controller;

import java.sql.Date;
import java.text.ParseException;
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
import fju.im.sa6.entity.WorkTime;

@Controller
@SessionAttributes("newaccount")

public class pageController {
	// StaffDefault newaccount = new Staff(6, "allen", 0, null, 0);

	static Cart shoppingCart = new Cart();

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexLoginpage() {
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
	@RequestMapping(value = "/showOrder", method = RequestMethod.GET)
	public ModelAndView showOrder() {
		ModelAndView model = new ModelAndView("showOrder");
		OrderListDAO orderListDAO = (OrderListDAO) context.getBean("OrderListDAO");
		ArrayList<OrderList> orderList = null;
		orderList = orderListDAO.getorderlist();
		model.addObject("orderList", orderList);

		return model;
	}

}
