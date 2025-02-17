package am.action;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test1Action {
    @RequestMapping("/member/login")
    public ModelAndView test1() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("ex1"); // WEB-INF/views/ex1.jsp를 의미함.
        return mv;
    }
    @RequestMapping("/member/test")
    public String test2() { //jsp로만 이동한다면 자료형을 String으로 사용해도된다.
        return "member/ex2"; // ex2.jsp를 호출하게 됨.
    }

}
