
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

//with Spring Security
//these methods are called after /j_spring_security_check

@Controller
@SessionAttributes("newaccount")
public class AccountController {

	@Autowired
	// static StaffDefault account_session = new Staff(0, null, 0, null, 0);
	static StaffDefault account_session;
	static StaffDefault temptest;
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@ModelAttribute("staffNum") int staffNum, HttpServletRequest request) {
		account_session = new Staff(0, null, 0, null, 0);

		ModelAndView model = new ModelAndView("redirect:/mainpage");
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		StaffDefault temp = new Staff(staffNum, "", 0, null, 0);
		StaffDefault staff = staffDefaultDAO.get(temp);

		if (staff.getStaffLevel() == 1) {
			model = new ModelAndView("redirect:/login2");
			temptest = staff;

		} else {
			account_session = staff;
			// session add
			model.addObject("newaccount", account_session);
		}
		return model;
	}

	@RequestMapping(value = "/login2", method = RequestMethod.GET)
	public ModelAndView login2() {
		ModelAndView model = new ModelAndView("login2");
		
		
		return model;
	}

	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public ModelAndView login2(@ModelAttribute("password") String password, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("redirect:/mainpage");

		if (password.equals("1234")) {
			account_session = temptest;
			model.addObject("newaccount", account_session);			
		}
		else{
			temptest = null;
			model = new ModelAndView("redirect:/login");
		}
		

//		account_session = staff;
		// session add
		model.addObject("newaccount", account_session);
		return model;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("redirect:/");// mapping page

		account_session = new Staff(0, null, 0, null, 0);
		;
		// session add
		model.addObject("newaccount", account_session);
		return model;
	}

	//
	// @RequestMapping(value = "/check", method = RequestMethod.POST)
	// public ModelAndView manegerCheck(@ModelAttribute StaffDefault
	// staffDefault) {
	// ModelAndView model = new ModelAndView("");
	// StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO)
	// context.getBean("StaffDefaultDAO");
	// if (1 == 1) {
	// model = new ModelAndView("redirect:/mainpage");
	// model.addObject("staffDefault", staffDefault);
	// } else {
	// model = new ModelAndView("index");
	// }
	//
	// return model;
	// }

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
		// StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO)
		// context.getBean("StaffDefaultDAO");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
		worktimeDAO.statffOnWork(account_session);
		return model;
	}

	@RequestMapping(value = "/offwork", method = RequestMethod.GET)
	public ModelAndView offwork() {
		ModelAndView model = new ModelAndView("redirect:mainpage");
		// StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO)
		// context.getBean("StaffDefaultDAO");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
		worktimeDAO.staffOffWork(account_session);
		return model;
	}

	@RequestMapping(value = "/amend", method = RequestMethod.POST)
	public ModelAndView amend(@ModelAttribute("date") String date2, @ModelAttribute("submit") String submit,@ModelAttribute("staffNum") int staffNum,
			HttpServletRequest request) throws ParseException {
		
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		StaffDefault temp = new Staff(staffNum, "", 0, null, 0);
		StaffDefault staff = staffDefaultDAO.get(temp);
		
		
		System.out.print(date2);
		ModelAndView model = new ModelAndView("redirect:mainpage");
		String dat = date2.substring(0, 10);
		String tim = date2.substring(11);
		System.out.println(dat);
		System.out.println(tim);
		String date3 = dat + " " + tim;

		// String dateString = date;
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// java.util.Date date2 = null;
		// StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO)
		// context.getBean("StaffDefaultDAO");
		// WorktimeDAO worktimeDAO = (WorktimeDAO)
		// context.getBean("WorktimeDAO");
		// worktimeDAO.amendOnWork(account_session, date);
		if (Integer.parseInt(submit) == 1) {
			// model = new ModelAndView("amendonwork");
			model = new ModelAndView("redirect:mainpage");
			// StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO)
			// context.getBean("StaffDefaultDAO");
			WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
			worktimeDAO.amendOnWork(staff, date3);
		} else {
			// model = new ModelAndView("amendoffnwork");
			model = new ModelAndView("redirect:mainpage");
			// StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO)
			// context.getBean("StaffDefaultDAO");
			WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
			worktimeDAO.amendOffWork(staff, date2);
		}
		// model.addObject("date", date);
		return model;
	}

	// @RequestMapping(value = "/amendonwork", method = RequestMethod.GET)
	// public ModelAndView amendonwork(@ModelAttribute("date") Date date,
	// HttpServletRequest request) {
	// ModelAndView model = new ModelAndView("redirect:mainpage");
	// // StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO)
	// // context.getBean("StaffDefaultDAO");
	// WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
	// worktimeDAO.amendOnWork(account_session, date, null);
	// return model;
	// }
	//
	// @RequestMapping(value = "/amendoffwork", method = RequestMethod.GET)
	// public ModelAndView amendoffwork(@ModelAttribute("date") Date date,
	// HttpServletRequest request) {
	// ModelAndView model = new ModelAndView("redirect:mainpage");
	// // StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO)
	// // context.getBean("StaffDefaultDAO");
	// WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
	// worktimeDAO.amendOffWork(account_session, date, null);
	// return model;
	// }

	@RequestMapping(value = "/manageWorktimeSearch", method = RequestMethod.GET)
	public ModelAndView manageWorktime(@ModelAttribute("searchTime") Date searchTime, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("manageWorktimeSearch");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
		ArrayList<StaffDefault> arr;
		if (searchTime == null) {
			arr = new ArrayList<StaffDefault>();
		} else {
			arr = worktimeDAO.getDayWorktime(searchTime);
		}
		model.addObject("worktime", arr);
		return model;
	}

	@RequestMapping(value = "/manageWorktimeSearch", method = RequestMethod.POST)
	public ModelAndView manageWorktimeSearch() {
		ModelAndView model = new ModelAndView("redirect:manageWorktimeSearch");
		return model;
	}

	// @RequestMapping(value = "/worktimeSearch", method = RequestMethod.GET)
	// public ModelAndView worktimeSearch(Date searchTime) {
	// ModelAndView model = new ModelAndView("worktimeSearch");
	// WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
	// ArrayList<WorkTime> arr ;
	// if(searchTime == null){
	// arr = new ArrayList<WorkTime>();
	// }
	// else{
	// arr =worktimeDAO.searchworktime(searchTime);
	// }
	// model.addObject("worktime",arr);
	// return model;
	// }

	@RequestMapping(value = "/staffLevelModify", method = RequestMethod.GET)
	public ModelAndView staffLevelModify(@ModelAttribute("staffNum") int staffNum, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("staffModify");
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		StaffDefault temp = new Staff(staffNum, null, 0, null, 0);
		StaffDefault staff = staffDefaultDAO.get(temp);
		model.addObject("staff", staff);
		return model;
	}

	@RequestMapping(value = "/staffModify", method = RequestMethod.GET)
	public ModelAndView staffModify(@ModelAttribute("staffNum") int staffNum, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("staffModify");
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		StaffDefault temp = new Staff(staffNum, null, 0, null, 0);
		StaffDefault staff = staffDefaultDAO.get(temp);
		model.addObject("staff", staff);
		return model;
	}

	@RequestMapping(value = "/setLevel", method = RequestMethod.GET)
	public ModelAndView setLevel(@ModelAttribute("staffNum") int staffNum, HttpServletRequest request) {
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		StaffDefault temp = new Staff(staffNum, null, 0, null, 0);
		StaffDefault staff = staffDefaultDAO.get(temp);

		ModelAndView model = new ModelAndView("redirect:staffManage");
		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
		managerDAO.setLevel(account_session, staff);

		return model;

	}

	@RequestMapping(value = "/staffAdd", method = RequestMethod.GET)
	public ModelAndView staffAdd() {
		ModelAndView model = new ModelAndView("staffAdd");

		return model;
	}

	@RequestMapping(value = "/staffAdd", method = RequestMethod.POST)
	public ModelAndView staffAdd(@ModelAttribute StaffDefault staff) {
		ModelAndView model = new ModelAndView("redirect:staffManage");
		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
		managerDAO.add(staff);

		return model;

	}
	@RequestMapping(value = "/showMonth", method = RequestMethod.GET)
	public ModelAndView showMonth() {
		ModelAndView model = new ModelAndView("showMonth");

		return model;
	}
	
	@RequestMapping(value = "/showMonthAction", method = RequestMethod.POST)
	public ModelAndView showMonthAction(@ModelAttribute("date") Date date, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("redirect:showMonth");
		System.out.println(date);
		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
		double month = managerDAO.monthearntotal(date);

		model.addObject("earn", month);
		return model;
	}

	// @RequestMapping(value = "/Memployeemanagechange", method =
	// RequestMethod.GET)
	// public ModelAndView StaffChange() {
	// StaffDefault staffDefault2 = null;
	// if (tempStaffDefault == null) {
	// staffDefault2 = new Staff(0, null, 0, null, 0);
	// tempStaffDefault = null;
	// } else {
	// staffDefault2 = tempStaffDefault;
	// tempStaffDefault = null;
	// }
	// ModelAndView model = new ModelAndView("redirect:/Memployeemanage");//
	// mapping
	// // page
	// ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
	// managerDAO.set(staffDefault2);
	// return model;
	// }
	//
	// @RequestMapping(value = "/Memployeeadd", method = RequestMethod.POST)
	// public ModelAndView addStaff(@ModelAttribute StaffDefault staffDefault) {
	// ModelAndView model = new ModelAndView("redirect:/Memployeemanage");//
	// mapping
	// // page
	// ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
	// managerDAO.add(staffDefault);
	// return model;
	// }
	//
	 @RequestMapping(value = "/staffRemove", method = RequestMethod.GET)
	 public ModelAndView removeStaff(@ModelAttribute("staffNum") int staffNum, HttpServletRequest request) {
	 ModelAndView model = new ModelAndView("redirect:/staffManage");//

	 ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
	 StaffDefault temp = new Staff(staffNum, null, 0, null, 0);
	 managerDAO.remove(temp);
	 return model;
	 }

	// for manage
	@RequestMapping(value = "/managePage", method = RequestMethod.GET)
	public ModelAndView managePage() {
		ModelAndView model = new ModelAndView("managePage");

		if (account_session.getStaffLevel() == 1) {
			model = new ModelAndView("managePage");
		} else {
			model = new ModelAndView("redirect:mainpage");

		}
		return model;
	}

	@RequestMapping(value = "/amendWork", method = RequestMethod.GET)
	public ModelAndView amendWork() {
		ModelAndView model = new ModelAndView("managePage");

		if (account_session.getStaffLevel() == 1) {
			model = new ModelAndView("amendWork");
		} else {
			model = new ModelAndView("redirect:mainpage");

		}
		ArrayList<StaffDefault> staffList = null;
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		staffList = staffDefaultDAO.getList();
		model.addObject("staffList",staffList);

		return model;
	}

	@RequestMapping(value = "/staffManage", method = RequestMethod.GET)
	public ModelAndView staffManage() {

		ModelAndView model = new ModelAndView("managePage");

		if (account_session.getStaffLevel() == 1) {
			model = new ModelAndView("staffManage");
		} else {
			model = new ModelAndView("redirect:mainpage");

		}
		ArrayList<StaffDefault> staffList = null;
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		staffList = staffDefaultDAO.getList();
		model.addObject("staffList", staffList);

		return model;
	}

}
