package pm.action;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BbsControl {
    // 스프링 프레임워크가 알아서 DAO를 이어주는 어노테이션
    // 해당 객체가 생성될때, 원하는 객체가 미리 만들어져서 준비되어 있어야 함.
    @Autowired
    private BbsDAO bbsDAO;

    @RequestMapping("/bbs/list")
    public ModelAndView bbsList() { //db에서 꺼내온것을 가져오기 위해 ModelAndView를 사용함.
        ModelAndView mv = new ModelAndView();

        //Mybatis로부터 DB에 있는 자원을 가져오기.
        BbsVO[] ar = bbsDAO.getList("BBS", 1, 10);
        mv.addObject("bbs_ar", ar);
        mv.setViewName("bbs/list");
        return mv;
    }
}
