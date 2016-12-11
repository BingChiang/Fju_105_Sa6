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

import fju.im.sa6.dao.InventoryDAO;
import fju.im.sa6.dao.ManagerDAO;
import fju.im.sa6.dao.ProductDAO;
import fju.im.sa6.dao.StaffDefaultDAO;
import fju.im.sa6.dao.WorktimeDAO;
import fju.im.sa6.entity.Inventory;
import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.Staff;
import fju.im.sa6.entity.StaffDefault;
import fju.im.sa6.entity.WorkTime;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;

//with Spring Security
//these methods are called after /j_spring_security_check

@Controller
//@SessionAttributes("newaccount")
public class AccountController {
	
	@Autowired
	static StaffDefault account_session = new Staff(6,"allen",0,0);

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("redirect:/mainpage");// mapping page
//		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
//		StaffDefault temp = new Staff(staffNum,"",0,0);
//		StaffDefault staff = staffDefaultDAO.get(temp);
		model = new ModelAndView("redirect:/mainpage");
//		account_session = staff;
		// session add
		model.addObject("newaccount", account_session);
		return model;
	}
//
//	@RequestMapping(value = "/check", method = RequestMethod.POST)
//	public ModelAndView manegerCheck(@ModelAttribute StaffDefault staffDefault) {
//		ModelAndView model = new ModelAndView("");
//		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
//		if (1 == 1) {
//			model = new ModelAndView("redirect:/mainpage");
//			model.addObject("staffDefault", staffDefault);
//		} else {
//			model = new ModelAndView("index");
//		}
//
//		return model;
//	}

	@RequestMapping(value = "/worktime", method = RequestMethod.GET)
	public ModelAndView ListStaffWorktime() {
		ArrayList<StaffDefault> staffDefaultList = new ArrayList<StaffDefault>();
		ModelAndView model = new ModelAndView("");// mapping page
		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
		staffDefaultList = managerDAO.getList();
		model.addObject("employeeList", staffDefaultList);
		return model;
	}

	@RequestMapping(value = "/onwork", method = RequestMethod.GET)
	public ModelAndView onwork() {
		ModelAndView model = new ModelAndView("redirect:mainpage");
//		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
		worktimeDAO.statffOnWork(account_session);
		return model;
	}

	@RequestMapping(value = "/offwork", method = RequestMethod.GET)
	public ModelAndView offwork() {
		ModelAndView model = new ModelAndView("redirect:mainpage");
//		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
		worktimeDAO.staffOffWork(account_session);
		return model;
	}

	
	@RequestMapping(value = "/amend", method = RequestMethod.POST)
	public ModelAndView amend(Date date , String submit) {
		ModelAndView model = new ModelAndView("");
//		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
//		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
//		worktimeDAO.amendOnWork(account_session, date);
		if(Integer.parseInt(submit)==1){
			model = new ModelAndView("amendonwork");
		}
		else{
			model = new ModelAndView("amendonwork");
		}
		model.addObject("date",date);
		return model;
	}
	
	@RequestMapping(value = "/amendonwork", method = RequestMethod.GET)
	public ModelAndView amendonwork(Date date) {
		ModelAndView model = new ModelAndView("redirect:mainpage");
//		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
		worktimeDAO.amendOnWork(account_session, date);
		return model;
	}

	@RequestMapping(value = "/amendoffwork", method = RequestMethod.GET)
	public ModelAndView amendoffwork(Date date) {
		ModelAndView model = new ModelAndView("redirect:mainpage");
//		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
		worktimeDAO.amendOffWork(account_session, date);
		return model;
	}

	
	@RequestMapping(value = "/manageWorktimeSearch", method = RequestMethod.GET)
	public ModelAndView manageWorktime(Date searchTime) {
		ModelAndView model = new ModelAndView("manageWorktimeSearch");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
		ArrayList<StaffDefault> arr ;	
		if(searchTime == null){
				arr = new ArrayList<StaffDefault>();
			}
		else{
			arr = worktimeDAO.getDayWorktime(searchTime);
		}
		model.addObject("worktime",arr);	
		return model;
	}
	
	
	@RequestMapping(value = "/manageWorktimeSearch", method = RequestMethod.POST)
	public ModelAndView manageWorktimeSearch() {
		ModelAndView model = new ModelAndView("redirect:manageWorktimeSearch");
		return model;
	}
	
//	@RequestMapping(value = "/worktimeSearch", method = RequestMethod.GET)
//	public ModelAndView worktimeSearch(Date searchTime) {
//		ModelAndView model = new ModelAndView("worktimeSearch");
//		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
//		ArrayList<WorkTime> arr ;	
//		if(searchTime == null){
//				arr = new ArrayList<WorkTime>();
//			}
//		else{
//			arr =worktimeDAO.searchworktime(searchTime);
//		}
//		model.addObject("worktime",arr);	
//		return model;
//	}
	
	
	@RequestMapping(value = "/worktimeSearch", method = RequestMethod.POST)
	public ModelAndView worktimeSearch() {
		ModelAndView model = new ModelAndView("redirect:worktimeSearch");
		return model;
	}
	
	
	@RequestMapping(value = "/staffModify", method = RequestMethod.GET)
	public ModelAndView staffModify(int staffNum) {
		ModelAndView model = new ModelAndView("staffModify");
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		StaffDefault temp = new Staff(staffNum,null,0,0);
		StaffDefault staff = staffDefaultDAO.get(temp);
		model.addObject("staff",staff);
		return model;
	}
	
	@RequestMapping(value = "/staffModify", method = RequestMethod.POST)
	public ModelAndView invertoryModify(@ModelAttribute StaffDefault staff) {
		ModelAndView model = new ModelAndView("redirect:staffManage");
		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
		managerDAO.set(staff);

		return model;

	}
	
	@RequestMapping(value = "/staffAdd", method = RequestMethod.GET)
	public ModelAndView staffAdd() {
		ModelAndView model = new ModelAndView("staffModify");

		return model;
	}
	
	@RequestMapping(value = "/staffAdd", method = RequestMethod.POST)
	public ModelAndView staffAdd(@ModelAttribute StaffDefault staff) {
		ModelAndView model = new ModelAndView("redirect:staffManage");
		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
		managerDAO.add(staff);

		return model;

	}
	
	

//	@RequestMapping(value = "/Memployeemanagechange", method = RequestMethod.GET)
//	public ModelAndView StaffChange() {
//		StaffDefault staffDefault2 = null;
//		if (tempStaffDefault == null) {
//			staffDefault2 = new Staff(0, null, 0, null, 0);
//			tempStaffDefault = null;
//		} else {
//			staffDefault2 = tempStaffDefault;
//			tempStaffDefault = null;
//		}
//		ModelAndView model = new ModelAndView("redirect:/Memployeemanage");// mapping
//																			// page
//		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
//		managerDAO.set(staffDefault2);
//		return model;
//	}
//
//	@RequestMapping(value = "/Memployeeadd", method = RequestMethod.POST)
//	public ModelAndView addStaff(@ModelAttribute StaffDefault staffDefault) {
//		ModelAndView model = new ModelAndView("redirect:/Memployeemanage");// mapping
//																			// page
//		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
//		managerDAO.add(staffDefault);
//		return model;
//	}
//
//	@RequestMapping(value = "/removeStaff", method = RequestMethod.POST)
//	public ModelAndView removeStaff(@ModelAttribute StaffDefault staffDefault) {
//		ModelAndView model = new ModelAndView("redirect:/Memployeemanage");// mapping
//																			// page
//		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
//		managerDAO.remove(staffDefault);
//		return model;
//	}

}