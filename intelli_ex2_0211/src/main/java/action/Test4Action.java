package action;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;


@Controller
public class Test4Action {

    @RequestMapping("/t4.inc") // /t4.inc를 호출하면 해당 함수를 불러냄.
    public ModelAndView test() { //함수 생성
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "연습TEST");
        mv.setViewName("ex4");
        return mv;
    }
    @RequestMapping("/t5.inc")
    public ModelAndView exe() {
        ModelAndView mv = new ModelAndView();
        LocalDate now = LocalDate.now();
        mv.addObject("date", now.toString());
        mv.setViewName("ex5");
        return mv;
    }
    @RequestMapping("/t6.inc")
    public ModelAndView test(String v1) { //request.getparameter와 같은 기능을 한다.
        String msg = "회원";

        //받은 v1이라는 파라미터의 값이 "admin"이면 msg에 값을 "관리자"로 변경하자.

        if(v1 != null && v1.equalsIgnoreCase("admin")) {
            msg = "관리자";
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", msg);

        //뷰 페이지 지정
        mv.setViewName("ex6");
        return mv;
    }
}
