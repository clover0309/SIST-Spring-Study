package action;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test1Action extends AbstractController {

    public Test1Action() {
        System.out.println("Test1Action Get");
    }
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //jsp에서 표현할 정보들을 request에 저장.
        request.setAttribute("msg", "환영합니다.");

        //스프링환경에서는 request를 사용하는 것보다 ModelAndView를 사용함.
        ModelAndView mv = new ModelAndView();

        //jsp에서 표현할 자원을 ModelAndView에 저장한다.
        mv.addObject("str", "Spring MVC Practice");

        //반환될 때, mv가 request에 자동으로 저장된다.
        //그리고 forward할 jsp를 ModelAndView에 지정해야 한다.
        mv.setViewName("ex1");

        //마지막에는 mv에 반환을 해줘야, ModelAndView로 간다.
        return mv;
    }
}
