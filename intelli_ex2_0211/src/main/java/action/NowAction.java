package action;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class NowAction implements Controller {

    public NowAction() {
        System.out.println("Get NowAction");
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();

        LocalDate today = LocalDate.now();

        mv.addObject("today", today.toString());

        mv.setViewName("ex2"); // WEB-INF/jsp/ex2.jsp를 의미함.

        return mv;
    }
}
