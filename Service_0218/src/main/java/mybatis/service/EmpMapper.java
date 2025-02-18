package mybatis.service;

import mybatis.vo.EmpVO;

public interface EmpMapper {
  EmpVO[] allEmp() throws Exception;
  EmpVO selectEmpById(String empno) throws Exception;
  EmpVO[] search(String type, String value);
}
