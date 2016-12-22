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
import fju.im.sa6.dao.OrderListDAO;
import fju.im.sa6.dao.ProductDAO;
import fju.im.sa6.dao.StaffDefaultDAO;
import fju.im.sa6.dao.SupplierDAO;
import fju.im.sa6.dao.TypeDAO;
import fju.im.sa6.dao.WorktimeDAO;
import fju.im.sa6.entity.Inventory;
import fju.im.sa6.entity.OrderList;
import fju.im.sa6.entity.Product;
import fju.im.sa6.entity.Staff;
import fju.im.sa6.entity.StaffDefault;
import fju.im.sa6.entity.Supplier;
import fju.im.sa6.entity.Type;
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
		} else {
			temptest = null;
			model = new ModelAndView("redirect:/login");
		}

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
	public ModelAndView amend(@ModelAttribute("date") String date2, @ModelAttribute("submit") String submit,
			@ModelAttribute("staffNum") int staffNum, HttpServletRequest request) throws ParseException {

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
	public ModelAndView showMonthAction(@ModelAttribute("searchTime") String date, HttpServletRequest request) {
		System.out.println("test:" + date);

		ModelAndView model = new ModelAndView("showMonth");
		System.out.println(date);
		ManagerDAO managerDAO = (ManagerDAO) context.getBean("ManagerDAO");
		int month = (int) managerDAO.monthearntotal(date);
		Product displaytemp = new Product();
		displaytemp.setProductPrice(250);
		model.addObject("earn", displaytemp);
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
			return model;
		} else {
			model = new ModelAndView("redirect:mainpage");
			return model;

		}
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
		model.addObject("staffList", staffList);

		return model;
	}

	@RequestMapping(value = "/staffManage", method = RequestMethod.GET)
	public ModelAndView staffManage() {
		if (account_session.getStaffLevel() == 0) {
			ModelAndView model = new ModelAndView("mainpage");
			return model;
		} else {

			ModelAndView model = new ModelAndView("staffManage");

			ArrayList<StaffDefault> staffList = null;
			StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
			staffList = staffDefaultDAO.getList();
			model.addObject("staffList", staffList);

			return model;
		}
	}

	@RequestMapping(value = "/inventoryManage", method = RequestMethod.GET)
	public ModelAndView inventoryManage() {
		if (account_session.getStaffLevel() == 0) {
			ModelAndView model = new ModelAndView("mainpage");
			return model;
		} else {
			ModelAndView model = new ModelAndView("inventoryManage");
			InventoryDAO inventoryDAO = (InventoryDAO) context.getBean("InventoryDAO");
			ArrayList<Inventory> invList = null;
			invList = inventoryDAO.getList();
			System.out.println(invList.get(invList.size() - 1).getUpdateDate());
			model.addObject("inventoryList", invList);
			return model;
		}
	}

	@RequestMapping(value = "/supplierManage", method = RequestMethod.GET)
	public ModelAndView supplierManage() {
		if (account_session.getStaffLevel() == 0) {
			ModelAndView model = new ModelAndView("mainpage");
			return model;
		} else {
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
	}

	@RequestMapping(value = "/productManage", method = RequestMethod.GET)
	public ModelAndView productManage() {
		if (account_session.getStaffLevel() == 0) {
			ModelAndView model = new ModelAndView("mainpage");
			return model;
		} else {
			ModelAndView model = new ModelAndView("productManage");
			ProductDAO productDAO = (ProductDAO) context.getBean("ProductDAO");
			ArrayList<Product> proList = null;
			proList = productDAO.getList();
			model.addObject("productList", proList);
			return model;
		}
	}

	@RequestMapping(value = "/productTypeManage", method = RequestMethod.GET)
	public ModelAndView productTypeManage() {
		if (account_session.getStaffLevel() == 0) {
			ModelAndView model = new ModelAndView("mainpage");
			return model;
		} else {
			ModelAndView model = new ModelAndView("productTypeManage");
			TypeDAO typeDAO = (TypeDAO) context.getBean("TypeDAO");
			ArrayList<Type> typeList = null;
			typeList = typeDAO.getList();
			model.addObject("typeList", typeList);
			return model;
		}
	}

	@RequestMapping(value = "/suplierManage", method = RequestMethod.GET)
	public ModelAndView suplierManage() {
		if (account_session.getStaffLevel() == 0) {
			ModelAndView model = new ModelAndView("mainpage");
			return model;
		} else {
			ModelAndView model = new ModelAndView("suplierManage");
			SupplierDAO supplierDAO = (SupplierDAO) context.getBean("SupplierDAO");
			ArrayList<Supplier> supplierList = null;
			supplierList = supplierDAO.getList();
			model.addObject("supplierList", supplierList);

			return model;
		}
	}

	@RequestMapping(value = "/worktimeSearch", method = RequestMethod.GET)
	public ModelAndView worktimeSearch() {
		if (account_session.getStaffLevel() == 0) {
			ModelAndView model = new ModelAndView("mainpage");
			return model;
		} else {
			ModelAndView model = new ModelAndView("worktimeSearch");
			ArrayList<StaffDefault> staffList = null;
			StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
			staffList = staffDefaultDAO.getList();
			model.addObject("staffList", staffList);
			return model;
		}
	}

	@RequestMapping(value = "/worktimeSearch", method = RequestMethod.POST)
	public ModelAndView worktimeSearch(@ModelAttribute("searchTime") String searchTime, HttpServletRequest request)
			throws ParseException {
		// ModelAndView model = new ModelAndView("redirect:worktimeSearch");
		ModelAndView model = new ModelAndView("worktimeSearch");
		// DAO ERROR
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
		ArrayList<WorkTime> workList = new ArrayList<WorkTime>();
		workList = worktimeDAO.searchworktime(searchTime);

		System.out.println("testController");
		// System.out.println(workList.get(0).getDate());
		model.addObject("workList", workList);
		return model;
	}

	@RequestMapping(value = "/staffWorktimeSearch", method = RequestMethod.POST)
	public ModelAndView staffWorktimeSearch(@ModelAttribute("staffNum") int staffNum, HttpServletRequest request)
			throws ParseException {
		// ModelAndView model = new ModelAndView("redirect:worktimeSearch");
		ModelAndView model = new ModelAndView("worktimeSearch");
		// DAO ERROR
		StaffDefaultDAO staffdefaultDAO =(StaffDefaultDAO)context.getBean("StaffDefaultDAO");
		WorktimeDAO worktimeDAO = (WorktimeDAO) context.getBean("WorktimeDAO");
		Staff temp = new Staff(staffNum,"",0,null,0);
		StaffDefault temp2 = staffdefaultDAO.get(temp);
		ArrayList<WorkTime> workList = new ArrayList<WorkTime>();
		
		ArrayList<StaffDefault> staffList = null;
		StaffDefaultDAO staffDefaultDAO = (StaffDefaultDAO) context.getBean("StaffDefaultDAO");
		staffList = staffDefaultDAO.getList();
		
		workList = worktimeDAO.staffSearchworktime(temp2);

		System.out.println("testController");
		// System.out.println(workList.get(0).getDate());
		
		model.addObject("staffList", staffList);
		model.addObject("workList", workList);
		return model;
	}
}