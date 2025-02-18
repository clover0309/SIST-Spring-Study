package mybatis.dao;

import mybatis.vo.EmpVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class EmpDAO {

    @Autowired
    private SqlSessionTemplate ss;

    public EmpVO[] getlist(){
      EmpVO[] ar = null;

      List<EmpVO> list = ss.selectList("emp.list");

      if(list != null && list.size() > 0){
        ar = new EmpVO[list.size()];
        list.toArray(ar);
      }

      return ar;
    }

    public EmpVO getEmp(String empno){
      return ss.selectOne("emp.getEmp", empno);
    }

    public EmpVO[] searchEmp(Map<String, String> map) {
      EmpVO[] ar = null;

      List<EmpVO> list = ss.selectList("emp.search", map);

      if (list != null && list.size() > 0) {
        ar = new EmpVO[list.size()];
        list.toArray(ar);
      }
      return ar;
    }
}
