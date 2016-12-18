package fju.im.sa6.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.servlet.http.HttpSession;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fju.im.sa6.dao.OrderListDAO;
import fju.im.sa6.dao.ProductDAO;
import fju.im.sa6.dao.TypeDAO;
import fju.im.sa6.entity.Cart;
import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.Type;

//@SessionAttributes("cartrrr")

@Controller
public class SalesOrderController {
	private ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
	// private static final Logger logger =
	// LoggerFactory.getLogger(ProductController.class);
	// configuration for session, please refer to:
	// http://tuhrig.de/making-a-spring-bean-session-scoped/
	@Autowired
	private Cart shoppingCart;

	// ArrayList<Product> cart2 = new ArrayList<Product>();
	// static int cartTotal=0;

	@RequestMapping(value = "/addCart", method = RequestMethod.GET)
	public ModelAndView addShoppingCart(@ModelAttribute("productNum") int productNum, HttpServletRequest request) {

		ModelAndView model = new ModelAndView("redirect:/productSale");
		// only id is passed
		// long pid = product.getProductNum();
		// System.out.println("pid="+pid);
		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		Product temp = new Product(productNum, 0, null, null, 0, 0, 0);
		Product temp2;
		temp2 = productDAO.get(temp);
		// Cart shoppingCart =
		shoppingCart.add(temp2);
		// ArrayList<Product> arr = shoppingCart.getCart();
		// int cartTotal = shoppingCart.orderTotal();
		// System.out.println(shoppingCart.count());
		model.addObject("typeNum", temp2.getTypeNum());
		model.addObject("cart", shoppingCart.getCart());
		// model.addObject("cartList",cart2);
		model.addObject("cartTotal", shoppingCart.orderTotal());
		return model;
	}
	//
	// @RequestMapping(value = "/showCart", method = RequestMethod.GET)
	// public ModelAndView showShoppingCart(){
	// ModelAndView model = new ModelAndView("showCart");
	// //ShoppingCart shoppingCart =
	// (ShoppingCart)context.getBean("shoppingCart");
	// List<Product> content = shoppingCart.getCart();
	// model.addObject("shoppingCart",content);
	// return model;
	// }

	@RequestMapping(value = "/cartclean", method = RequestMethod.GET)
	public ModelAndView cartclean() {
		ModelAndView model = new ModelAndView("productSale");

		shoppingCart.clean();
		model.addObject("cartTotal", shoppingCart.orderTotal());
		model.addObject("cartrrr", shoppingCart);
		model.addObject("typeNum", 1);
		return model;
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkout() {
		ModelAndView model = new ModelAndView("redirect:/productSale");
		// Cart shoppingCart = (Cart) context.getBean("Cart");
		OrderListDAO orderListDAO = (OrderListDAO) context.getBean("OrderListDAO");

		// List<Product> pList = shoppingCart.getCart();
		// List<Long> pList2 = new ArrayList<Long>();
		// OrderList temp = new OrderList(0, cartTotal, null, cart2);
		// orderListDAO.addorderlist(temp);

		// shoppingCart.clean();
		// for (int i=0; i<pList.size();i++){
		// pList2.add(pList.get(i).getId());
		// }
		// int result = 0;
		// try {
		// result = salesOrderDAO.sellProduct(pList2);
		// } catch (SQLException e) {
		//
		// e.printStackTrace();
		// }
		// System.out.println("result="+result);
		// if (result != 0){ //successfully updated, clean up shopping cart
		// shoppingCart.cleanup();
		// }
		OrderList ord = new OrderList(0, shoppingCart.orderTotal(), null, shoppingCart.getCart());
		orderListDAO.addorderlist(ord);

		shoppingCart.clean();
		model.addObject("cartTotal", shoppingCart.orderTotal());
		model.addObject("cartrrr", shoppingCart);
		model.addObject("typeNum", 1);
		return model;
	}

	@RequestMapping(value = "/productSale", method = RequestMethod.GET)
	public ModelAndView productSale(@ModelAttribute("typeNum") int typeNum, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("productSale");
		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		TypeDAO typeDAO = (TypeDAO) context.getBean("TypeDAO");
		ArrayList<Product> typeProList = null;
		ArrayList<Type> typeList = null;

		typeList = typeDAO.getList();

		Type temp = null;

		temp = new Type(null, typeNum, typeNum);
		typeProList = productDAO.getTypeList(temp);

		model.addObject("typeList", typeList);
		model.addObject("typeProList", typeProList);

		int cartTotal = shoppingCart.orderTotal();
		model.addObject("cartrrr", shoppingCart.getCart());
		model.addObject("cartTotal", cartTotal);

		return model;
	}

	@RequestMapping(value = "/cartClean", method = RequestMethod.GET)
	public ModelAndView cartClean() {
		ModelAndView model = new ModelAndView("redirect:productSale");
		shoppingCart.clean();
		ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
		TypeDAO typeDAO = (TypeDAO) context.getBean("TypeDAO");
		ArrayList<Product> typeProList = null;
		ArrayList<Type> typeList = null;

		typeList = typeDAO.getList();
		model.addObject("typeNum", 1);

		return model;
	}

	@RequestMapping(value = "/removecart", method = RequestMethod.GET)
	public ModelAndView removecart() {
		ModelAndView model = new ModelAndView("redirect:productSale");
		if ((shoppingCart.getCart().size()) > 0) {
			shoppingCart.getCart().remove(shoppingCart.getCart().size() - 1);
		}
		model.addObject("typeNum", 1);

		return model;
	}
}
