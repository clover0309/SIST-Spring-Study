package com.interceptor_0214;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MemberControl {
    //DB에서 인증을 거칠려면 DAO들이 있어야 함.


    @Autowired
    private HttpSession session;

    @RequestMapping("/login")
    public String login() { //GET방식 호출
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(
            @RequestParam String m_id, @RequestParam String m_pw) {
        ModelAndView mv = new ModelAndView();

        //DAO를 통해 DB 확인을 거쳐야함.

        //로그인 처리를 위한 세션처리 작업
        session.setAttribute("mvo", m_id);

        //redirect = 깔끔하게 다시 시작한다. 라는 의미와도 같다.
        mv.setViewName("redirect:/index");
        return mv;
    }
}
