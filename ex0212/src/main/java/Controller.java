import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

@WebServlet("*.inc")
public class Controller extends DispatcherServlet {
    // WEB-INF/{현재 컨트롤러명}-servlet.xml을 로드함(연동한다).

}
