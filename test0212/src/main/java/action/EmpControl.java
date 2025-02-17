package action;

import dao.EmpDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vo.EmpVO;

import java.util.List;

@Controller
public class EmpControl {
    // 스프링 프레임워크가 알아서 DAO를 이어주는 어노테이션
    // 해당 객체가 생성될때, 원하는 객체가 미리 만들어져서 준비되어 있어야 함.
    @Autowired
    private EmpDAO empDAO;

    @RequestMapping("/list")
    public ModelAndView empList() { //db에서 꺼내온것을 가져오기 위해 ModelAndView를 사용함.
        ModelAndView mv = new ModelAndView();

        List<EmpVO> ar = empDAO.getList();
        mv.addObject("empList", ar);
        mv.setViewName("emp/list");
        return mv;
    }
}
