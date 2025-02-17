import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("*.inc")

public class Controller extends DispatcherServlet {

}
