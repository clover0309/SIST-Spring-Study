package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import mybatis.vo.BbsVO;
import mybatis.vo.CommVO;
import org.springframework.stereotype.Component;

@Component
public class BbsDAO {
	@Autowired
	private SqlSessionTemplate ss;

	//총 게시물 수를 반환
	public int getTotalCount(String bname) {
		int cnt = ss.selectOne("bbs.totalCount", bname);

		return cnt;
	}

	// 목록
	public BbsVO[] getList(String bname, int begin, int end) {
		BbsVO[] ar = null;

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bname", bname);
		map.put("begin", begin);// String.valueOf(begin)
		map.put("end", end);

		List<BbsVO> list = ss.selectList("bbs.list", map);
		if(list != null && !list.isEmpty()) {
			ar = new BbsVO[list.size()];
			list.toArray(ar);
		}

		return ar;
	}
	//DB에 게시글 저장
	public int add(BbsVO vo) {

		int cnt = ss.insert("bbs.add", vo);

		return cnt;
	}
	//특정 게시물 검색
	public BbsVO getBbs(String b_idx){

		BbsVO vo = ss.selectOne("bbs.get_bbs", b_idx);

		return vo;
	}

	//조회수 증가.
	public int hitUp(String b_idx){

		int cnt = ss.update("bbs.hitUp", b_idx);

		return cnt;
	}
	//원글 수정
	public int edit(String b_idx, String title, String content,
						   String fname, String oname, String ip, String pwd) {
		HashMap<String, String> map = new HashMap<>();
		map.put("title", title);
		map.put("content", content);
		if(fname != null) {
			map.put("fname", fname);
			map.put("oname", oname);
		}
		map.put("ip", ip);
		map.put("pwd", pwd);
		map.put("b_idx", b_idx);


		int cnt = ss.update("bbs.edit", map);

		return cnt;
	}

	//댓글저장
	public int commAdd(String writer, String comm, String pwd, String b_idx, String ip) {
		CommVO vo = new CommVO();
		vo.setWriter(writer);
		vo.setContent(comm);
		vo.setPwd(pwd);
		vo.setB_idx(b_idx);
		vo.setIp(ip);


		int cnt = ss.insert("bbs.commAdd", vo);

		return cnt;
	}

	//원글 삭제
	public int del(String b_idx,String pwd){
		Map<String, String> map = new HashMap<>();
		map.put("b_idx", b_idx);
		map.put("pwd", pwd);
		int cnt = ss.update("bbs.del", map);


		return cnt;
	}
}