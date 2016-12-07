package fju.im.sa6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fju.im.sa6.dao.ManagerDAO;
import fju.im.sa6.dao.ProductDAO;
import fju.im.sa6.dao.StaffDefaultDAO;
import fju.im.sa6.dao.WorktimeDAO;
import fju.im.sa6.entity.Inventory;
import fju.im.sa6.entity.Staff;
import fju.im.sa6.entity.StaffDefault;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;

//with Spring Security
//these methods are called after /j_spring_security_check
@Controller
@SessionAttributes("newaccount")
public class AccountController {
	@Autowired
	private StaffDefault account_session;
<<<<<<< HEAD
	
	
=======


>>>>>>> origin/Bing
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
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView model = new ModelAndView("/index");
		//session setting
		return model;
	}
	
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView listAllSatff() {
		ModelAndView model = new ModelAndView();
		ArrayList<StaffDefault> allStaff = null;
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		allStaff = staffDefaultDAO.getList();
		//model.addObject(allStaff);
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView deleteProduct(@ModelAttribute StaffDefault staffDefault) {
		ModelAndView model = new ModelAndView("");//mapping page
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		if (staffDefault.getStaffLevel() == 0) {
			model = new ModelAndView("login2");
			model.addObject("staffDefault", staffDefault);//no session
		} else {
			model = new ModelAndView("mainpage");
		}
		//session add
		model.addObject("newaccount",account_session);  
		return model;
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public ModelAndView manegerCheck(@ModelAttribute StaffDefault staffDefault) {
		ModelAndView model = new ModelAndView("");
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		if (1 == 1) {
			model = new ModelAndView("mainpage");
			model.addObject("staffDefault", staffDefault);
		} else {
			model = new ModelAndView("index");
		}

		return model;
	}
	@RequestMapping(value = "/worktime", method = RequestMethod.GET)
	public ModelAndView ListStaffWorktime() {
		ArrayList<StaffDefault> staffDefaultList = new ArrayList<StaffDefault>();
		ModelAndView model = new ModelAndView("");//mapping page
		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
		staffDefaultList = managerDAO.getList();
		model.addObject("employeeList",staffDefaultList);
		return model;
	}
	
	
	@RequestMapping(value = "/onwork", method = RequestMethod.POST)
	public ModelAndView onwork(@ModelAttribute StaffDefault staffDefault) {
		ModelAndView model = new ModelAndView("redirect:/worktime");
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
		worktimeDAO.statffOnWork(staffDefault);
		return model;
	}
	
	@RequestMapping(value = "/offwork", method = RequestMethod.POST)
	public ModelAndView offwork(@ModelAttribute StaffDefault staffDefault) {
		ModelAndView model = new ModelAndView("redirect:/worktime");
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
		worktimeDAO.staffOffWork(staffDefault);
		return model;
	}

	@RequestMapping(value = "/amendonwork", method = RequestMethod.POST)
	public ModelAndView amendonwork(@ModelAttribute StaffDefault staffDefault,Date date) {
		ModelAndView model = new ModelAndView("redirect:/worktime");
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
		worktimeDAO.amendOnWork(staffDefault, date);
		return model;
	}
	
	@RequestMapping(value = "/amendoffwork", method = RequestMethod.POST)
	public ModelAndView amendoffwork(@ModelAttribute StaffDefault staffDefault,Date date) {
		ModelAndView model = new ModelAndView("redirect:/worktime");
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
		worktimeDAO.amendOffWork(staffDefault, date);
		return model;
	}
	@RequestMapping(value = "/Memployeemanage", method = RequestMethod.GET)
	public ModelAndView ListStaff() {
		ArrayList<StaffDefault> staffDefaultList = new ArrayList<StaffDefault>();
		ModelAndView model = new ModelAndView("");//mapping page
		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
		staffDefaultList = managerDAO.getList();
		model.addObject("employeeList",staffDefaultList);
		return model;
	}
	
	static StaffDefault tempStaffDefault = null;
	
	@RequestMapping(value = "/Memployeemanagechange", method = RequestMethod.POST)
	public ModelAndView postStaffTochange(@ModelAttribute StaffDefault staffDefault) {
		ModelAndView model = new ModelAndView("redirect:/Memployeemanagechange");//mapping page
		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
		StaffDefault staffDefault2 = managerDAO.get(staffDefault);
		tempStaffDefault = staffDefault2;
		return model;
	}
	
	@RequestMapping(value = "/Memployeemanagechange", method = RequestMethod.GET)
	public ModelAndView StaffChange() {
		StaffDefault staffDefault2 = null;
		if (tempStaffDefault == null) {
			staffDefault2 = new Staff(0, null, 0, null, 0);
			tempStaffDefault = null;
		} else {
			staffDefault2 = tempStaffDefault;
			tempStaffDefault = null;
		}
		ModelAndView model = new ModelAndView("redirect:/Memployeemanage");//mapping page
		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
		managerDAO.set(staffDefault2);
		return model;
	}
	
	
	
	@RequestMapping(value = "/Memployeeadd", method = RequestMethod.POST)
	public ModelAndView addStaff(@ModelAttribute StaffDefault staffDefault) {
		ModelAndView model = new ModelAndView("redirect:/Memployeemanage");//mapping page
		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
		managerDAO.add(staffDefault);
		return model;
	}
	
	@RequestMapping(value = "/removeStaff", method = RequestMethod.POST)
	public ModelAndView removeStaff(@ModelAttribute StaffDefault staffDefault) {
		ModelAndView model = new ModelAndView("redirect:/Memployeemanage");//mapping page
		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
		managerDAO.remove(staffDefault);
		return model;
	}
	


	
}
