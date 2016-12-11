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

import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.Staff;
import fju.im.sa6.entity.StaffDefault;
import fju.im.sa6.entity.Type;
import fju.im.sa6.dao.ManagerDAO;
import fju.im.sa6.dao.OrderListDAO;
import fju.im.sa6.dao.ProductDAO;
import fju.im.sa6.dao.StaffDefaultDAO;
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
	


}
