package fju.im.sa6.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import fju.im.sa6.dao.ProductDAO;
import fju.im.sa6.dao.StaffDefaultDAO;
import fju.im.sa6.dao.WorktimeDAO;
import fju.im.sa6.entity.StaffDefault;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;

//with Spring Security
//these methods are called after /j_spring_security_check
@Controller
public class AccountController {

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/loginSuccessful", method = RequestMethod.GET)
	public ModelAndView loginSuccessful(Principal principal) {

		ModelAndView model = new ModelAndView("redirect:/product");
		// http://www.baeldung.com/get-user-in-spring-security
		System.out.println(principal.getName());

		return model;
	}

	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public ModelAndView loginFailed() {
		ModelAndView model = new ModelAndView("index");
		System.out.println("failed");
		model.addObject("message", "登入失敗");
		return model;
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView listAllSatff() {
		ModelAndView model = new ModelAndView();
		ArrayList<StaffDefault> allStaff = null;
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("staffDefaultDAO");
		allStaff = staffDefaultDAO.getList();
		model.addObject(allStaff);
		return model;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView deleteProduct(@ModelAttribute StaffDefault staffDefault) {
		ModelAndView model = new ModelAndView("redirect:/staffDefault");
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("staffDefaultDAO");
		if (staffDefault.getStaffLevel() == 0) {
			model = new ModelAndView("login2");
			model.addObject("staffDefault", staffDefault);
		} else {
			model = new ModelAndView("mainpage");
		}
		return model;
	}

	@RequestMapping(value = "check", method = RequestMethod.POST)
	public ModelAndView manegerCheck(@ModelAttribute StaffDefault staffDefault) {
		ModelAndView model = new ModelAndView("redirect:/staffDefault");
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("staffDefaultDAO");
		if (1 == 1) {
			model = new ModelAndView("mainpage");
			model.addObject("staffDefault", staffDefault);
		} else {
			model = new ModelAndView("index");
		}

		return model;
	}
	
	@RequestMapping(value = "onwork", method = RequestMethod.POST)
	public ModelAndView onwork(@ModelAttribute StaffDefault staffDefault) {
		ModelAndView model = new ModelAndView("redirect:/staffDefault");
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("staffDefaultDAO");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("worktimeDao");
		worktimeDAO.statffOnWork(staffDefault);
		return model;
	}
	
	@RequestMapping(value = "offwork", method = RequestMethod.POST)
	public ModelAndView offwork(@ModelAttribute StaffDefault staffDefault) {
		ModelAndView model = new ModelAndView("redirect:/staffDefault");
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("staffDefaultDAO");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("worktimeDao");
		worktimeDAO.staffOffWork(staffDefault);
		return model;
	}

	@RequestMapping(value = "amendonwork", method = RequestMethod.POST)
	public ModelAndView amendonwork(@ModelAttribute StaffDefault staffDefault,Date date) {
		ModelAndView model = new ModelAndView("redirect:/staffDefault");
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("staffDefaultDAO");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("worktimeDao");
		worktimeDAO.amendOnWork(staffDefault, date);
		return model;
	}
	
	@RequestMapping(value = "amendoffwork", method = RequestMethod.POST)
	public ModelAndView amendoffwork(@ModelAttribute StaffDefault staffDefault,Date date) {
		ModelAndView model = new ModelAndView("redirect:/staffDefault");
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("staffDefaultDAO");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("worktimeDao");
		worktimeDAO.amendOffWork(staffDefault, date);
		return model;
	}
	
}
