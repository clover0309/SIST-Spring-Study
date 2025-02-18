package mybatis.service;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class EmpService implements EmpMapper{

  @Autowired
  private EmpDAO empDAO;

  @Override
  public EmpVO[] allEmp() throws Exception {
    return empDAO.getlist();
  }

  @Override
  public EmpVO selectEmpById(String empno) throws Exception {
    return empDAO.getEmp(empno);
  }

  @Override
  public EmpVO[] search(String type, String value) {
    //인자로 넘어온 type과 value를 Map구조화 시킨다.
    HashMap<String, String> map = new HashMap<>();
    map.put("searchType", type);
    map.put("searchValue", value);
    return empDAO.searchEmp(map);
  }
}
