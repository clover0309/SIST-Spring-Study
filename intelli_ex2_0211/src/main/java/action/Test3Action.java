package action;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test3Action implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String v1 = request.getParameter("v1");
        String msg = "회원";

        //받은 v1이라는 파라미터의 값이 "admin"이면 msg에 값을 "관리자"로 변경하자.

        if(v1 != null && v1.equalsIgnoreCase("admin")) {
            msg = "관리자";
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", msg);

        //뷰 페이지 지정
        mv.setViewName("ex3");
        return mv;
    }
}
