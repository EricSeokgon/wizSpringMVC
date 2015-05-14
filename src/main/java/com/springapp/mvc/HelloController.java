package com.springapp.mvc;

import com.springapp.mvc.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;


@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world! 안녕하세요");
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

    //	@RequestMapping("/member/join")
//	public String joinData(@RequestParam("name") String name, @RequestParam("id") String id,
//			@RequestParam("pw") String pw, @RequestParam("email") String email, Model model) {
//
//		Member member = new Member();
//		member.setName(name);
//		member.setId(id);
//		member.setPw(pw);
//		member.setEmail(email);
//
//		model.addAttribute("memberInfo", member);
//
//		return "member/join";
//	}

    @RequestMapping("/member/join")
    public String joinData(Member member) {

        return "member/join";
    }

    @RequestMapping("/member/{studentId}")
    public String getStudent(@PathVariable String studentId, Model model) {
        model.addAttribute("studentId", studentId);
        return "member/studentView";
    }

    @RequestMapping("/index")
    public String goIndex() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/student")
    public String goStudent(HttpServletRequest httpServletRequest, Model model) {

        System.out.println("RequestMethod.GET");

        String id = httpServletRequest.getParameter("id");
        System.out.println("id : " + id);
        model.addAttribute("studentId", id);

        return "student/studentId";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/student")
    public ModelAndView goStudent(HttpServletRequest httpServletRequest) {

        System.out.println("RequestMethod.POST");

        String id = httpServletRequest.getParameter("id");
        System.out.println("id : " + id);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("student/studentId");
        mv.addObject("studentId", id);

        //model.addAttribute("studentId", id);

        //return "student/studentId";
        return mv;
    }

}