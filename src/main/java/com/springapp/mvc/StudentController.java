package com.springapp.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Project: wizSpringMVC
 * FileName: StudentController
 * Date: 2015-05-15
 * Time: 오전 9:39
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class StudentController {

	/*
	@RequestMapping("/student/create")
	public String studentCreate(@ModelAttribute("student") Student student, BindingResult result) {

		String page = "createDonePage";

		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);
		if(result.hasErrors()) {
			page = "createPage";
		}

		return page;
	}
	*/

    @RequestMapping("/student/create")
    public String studentCreate(@ModelAttribute("student") @Valid Student student, BindingResult result) {

        String page = "createDonePage";

//		StudentValidator validator = new StudentValidator();
//		validator.validate(student, result);
        if(result.hasErrors()) {
            page = "createPage";
        }

        return page;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(new StudentValidator());
    }

}
