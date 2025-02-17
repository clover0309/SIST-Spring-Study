package mybatis.dao;

import java.util.HashMap;
import java.util.List;

import mybatis.vo.BbsVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component

public class BbsDAO {
	@Autowired
	private SqlSessionTemplate ss; //리스너에 의해 움직이는

	//root-context.xml에서 ss를 생성하여, 자동으로 멤버변수 ss에 저장되도록 한다.

//	public void setSs(SqlSessionTemplate ss) {
//		this.ss = ss; //autowired를 선언하였으므로 이제는 setterInjection은 의미가 없다.
//	}
	public BbsDAO() {
		System.out.println("BbsDAO 생성");
	}

	public BbsVO[] getList(String bname, int begin, int end) {
		BbsVO[] ar = null;

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bname", bname);
		map.put("begin", begin);// String.valueOf(begin)
		map.put("end", end);

		List<BbsVO> list = ss.selectList("bbs.list", map);
		if (list != null && !list.isEmpty()) {
			ar = new BbsVO[list.size()];
			list.toArray(ar);
		}

		return ar;
	}
}