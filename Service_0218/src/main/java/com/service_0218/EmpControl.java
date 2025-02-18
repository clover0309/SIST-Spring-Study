package com.service_0218;

import mybatis.service.EmpMapper;
import mybatis.service.EmpService;
import mybatis.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpControl {

  @Autowired
  private EmpMapper empMapper;

  @RequestMapping("empList")
  public String empList(Model model) {
    try {
      //사원들 모두의 정보를 가져온다.
      EmpVO[] ar = empMapper.allEmp();
      model.addAttribute("ar", ar);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "empList";
  }

  @RequestMapping(value = "empSearch", method = RequestMethod.POST)
  public ModelAndView empSearch(String type, String value) {
      ModelAndView mv = new ModelAndView("empSearch");
      EmpVO[] ar = empMapper.search(type, value);

      mv.addObject("ar", ar);
      return mv;
  }
}
