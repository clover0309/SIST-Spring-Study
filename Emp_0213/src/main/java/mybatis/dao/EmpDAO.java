package mybatis.dao;

import mybatis.vo.EmpVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmpDAO {
    //톰캣이 구동될 때 미리 생성된 SqlSessionTemplate이 자동으로 저장되도록 하자.
    @Autowired
    private SqlSessionTemplate ss;

    public EmpVO[] getTotal(){
        List<EmpVO> list = ss.selectList("emp.total");
        EmpVO[] ar = null;

        if(ar != null) {
            ar = new EmpVO[list.size()];
            list.toArray(ar);
        }
        return ar;
    }
}
