package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Project: wizSpringMVC
 * FileName: StudentController
 * Date: 2015-05-15
 * Time: ¿ÀÀü 9:39
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class StudentController {

    @RequestMapping("/studentForm")
    public String studentForm() {
        return "createPage";
    }

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
}
