package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.StringTokenizer;

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

    @RequestMapping("/board/confirmId")
    public String confirmld(HttpServletRequest httpServletRequest, Model model) {
        String id = httpServletRequest.getParameter("id");
        String pw = httpServletRequest.getParameter("pw");
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "board/confirmId";
    }

    @RequestMapping("board/checkId")
    public String checkId(@RequestParam("id") String id, @RequestParam("pw") int pw, Model model) {
        model.addAttribute("identify", id);
        model.addAttribute("password", pw);
        return "board/checkId";

    }
}