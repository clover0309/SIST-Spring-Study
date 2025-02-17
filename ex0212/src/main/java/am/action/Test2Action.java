package am.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test2Action {
    private String msg = "쌍용교육센터";

    @RequestMapping("/board/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", msg);
        mv.setViewName("board/list");
        return mv;
    }
    @RequestMapping("/board/view")
    public ModelAndView view() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", msg);
        mv.setViewName("board/view");
        return mv;
    }
}
