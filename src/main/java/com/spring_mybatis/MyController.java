package com.spring_mybatis;


import com.spring_mybatis.dao.ContentDao;
import com.spring_mybatis.dto.ContentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MyController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	
	ContentDao dao1;
	

	public void setDao(ContentDao dao1) {
		this.dao1 = dao1;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/mybitas", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/mylist")
	public String list(Model model) {
		ArrayList<ContentDto> dtos = dao1.listDao();
		model.addAttribute("list", dtos);
		
		return "/list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		
		return "/writeForm";
	}
	
	@RequestMapping("/mywrite")
	public String write(HttpServletRequest request, Model model) {
		dao1.writeDao(request.getParameter("mWriter"), request.getParameter("mContent"));
		return "redirect:list";
	}
	
	@RequestMapping("/view")
	public String view() {
		
		return "/view";
	}
	
	@RequestMapping("/mydelete")
	public String delete(HttpServletRequest request, Model model) {
		dao1.deleteDao(request.getParameter("mId"));
		return "redirect:list";
	}
	
}
