import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

@WebServlet("*.inc")
public class Controller extends DispatcherServlet {
    //현재 컨트롤러가 WEB-INF/{현재컨트롤러명}-servlet.xml과 연동되었다.
}
