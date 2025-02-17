package spring.interceptor;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //반환값 준비.
        boolean result = true;

        //로그인 체크를 해서 만약! 로그인이 안된 상태일때,
        //result에 false를 저장한다. 먼저 로그인 체크를 하기 위해
        // HttpSession을 얻어내자.
        HttpSession session = request.getSession();

        //session에 "mvo"라는 이름으로 저장된 정보가 있는지 검증.
        Object obj = session.getAttribute("mvo");

        if (obj == null) {
            response.sendRedirect("/login");
            result =  false;
        }

        //true를 반환하면 원래 가려고 했던 경로로 진행을 계속하지만,
        //false가 반환되면, 원래의 경로로 진행을 하지 못한다.
        return result;
    }
}
