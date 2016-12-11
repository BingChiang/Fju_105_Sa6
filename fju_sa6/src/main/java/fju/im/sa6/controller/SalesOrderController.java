package fju.im.sa6.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.Map;

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
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fju.im.sa6.dao.OrderListDAO;
import fju.im.sa6.dao.ProductDAO;
import fju.im.sa6.entity.Cart;
import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;

@Controller
public class SalesOrderController {
	private ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
	// private static final Logger logger =
	// LoggerFactory.getLogger(ProductController.class);
	// configuration for session, please refer to:
	// http://tuhrig.de/making-a-spring-bean-session-scoped/
	// @Autowired
	private Cart shoppingCart;

	@RequestMapping(value = "/addCart", method = RequestMethod.GET)
	public ModelAndView addShoppingCart(int productNum, int typeNum) {
		ModelAndView model = new ModelAndView("redirect:/productSale");
		// only id is passed
		// long pid = product.getProductNum();
		// System.out.println("pid="+pid);
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		Product temp = new Product(productNum, 0, null, null, 0, 0, 0);
		Product temp2;
		temp2 = productDAO.get(temp);// retrieve all information with id
		Cart shoppingCart = (Cart) context.getBean("Cart");
		shoppingCart.add(temp2);
		// System.out.println(shoppingCart.count());
		model.addObject("typeNum", typeNum);
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

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkout() {
		ModelAndView model = new ModelAndView("redirect:/productSale");
		Cart shoppingCart = (Cart) context.getBean("Cart");
		OrderListDAO orderListDAO = (OrderListDAO) context.getBean("OrderListDAO");

		// List<Product> pList = shoppingCart.getCart();
		// List<Long> pList2 = new ArrayList<Long>();
		OrderList temp = new OrderList(0, shoppingCart.orderTotal(), null, shoppingCart.getCart());
		orderListDAO.addorderlist(temp);

		shoppingCart.clean();
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
		return model;
	}

}
