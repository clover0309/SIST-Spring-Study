package dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vo.EmpVO;

import java.util.List;


@Component
public class EmpDAO {
	@Autowired
	private SqlSessionTemplate ss;

	public List<EmpVO> getList() {
		List<EmpVO> list = ss.selectList("emp.list");
		return list;
	}

	public void setSs(SqlSessionTemplate ss) {
		this.ss = ss;
	}
}