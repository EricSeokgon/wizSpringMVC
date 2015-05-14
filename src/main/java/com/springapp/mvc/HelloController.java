package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }

    @RequestMapping("/board/view")
    public String view() {
        return "board/view";
    }

    @RequestMapping("/board/content")
    public String content(Model model) {

        model.addAttribute("id", "abcde");
        return "board/content";
    }

   @RequestMapping("/board/reply")
    public ModelAndView reply() {

       ModelAndView mv = new ModelAndView();
        mv.addObject("id", "abcde");
        mv.setViewName("board/reply");
        return mv;
    }
}