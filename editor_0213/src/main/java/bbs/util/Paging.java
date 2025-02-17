package bbs.util;

public class Paging {
	int nowPage = 1; // 현재페이지 값 == cPage
	int numPerPage = 10; // 한 페이지당 보여질 게시물의 수

	//페이징을 위한 변수
	int totalRecord; // 총 게시물의 수

	int pagePerBlock = 5; // 한 블럭당 표현할 페이지 수
	int totalPage;// 전체 페이지 수

	int begin; // 현재 페이지 값에 따라 bbs_t테이블에서 가져올 게시물의 시작 행번호
	int end; // 현재 페이지 값에 따라 bbs_t테이블에서 가져올 게시물의 마지막 행번호

	int startPage; // 한 블럭의 시작페이지 값
	int endPage; // 한 블럭의 끝페이지 값

	//현재 객체를 생성할 때 기본생성자를 부르면 
	// 한 페이지당 게시물을 10개씩 보여주는 페이징 처리를 한다.
	public Paging() {}

	public Paging(int numPerPage, int pagePerBlock) {
		this.numPerPage = numPerPage;
		this.pagePerBlock = pagePerBlock;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) { // 현재 페이지 값이 변경될 때
		this.nowPage = nowPage;

		//현재 페이지 값이 변경되면 표현할 게시물들이 변경되어야 한다.
		// 즉, begin과 end값이 변경되어 DB로부터 다시 게시물들을 가져와야 함!

		//현재 페이지 값은 전체 페이지 값을 넘지 못하도록 하자!
		if(nowPage > totalPage)
			nowPage = totalPage;

		//각 페이지의 시작 행번호(begin)와 마지막 행번호(end)를 구한다.
		//예) 현재페이지:1, begin:1, end:10
		//예) 현재페이지:2, begin:11, end:20
		//예) 현재페이지:3, begin:21, end:30
		//예) 현재페이지:4, begin:31, end:40
		begin = (nowPage-1)*numPerPage+1;
		end = nowPage*numPerPage;

		//현재페이지 값에 의해 블럭의 시작페이지(startPage)구하자
		startPage = (int)((nowPage-1)/pagePerBlock)*pagePerBlock+1;
		//블럭의 마지막 페이지값 구하기
		endPage = startPage + pagePerBlock - 1;

		// 위에서 구한 마지막페이지 값이 전체페이지 수보다 클때가 우려된다.
		if(endPage > totalPage)
			endPage = totalPage;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	//총 게시물 수가 지정될 때 자동으로 전체 페이지 수를 구하면 좋을 것 같다.
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;

		//총 게시물 수가 지정되었으니 전체페이지 수를 구하자!
		/*
		this.totalPage = totalRecord/numPerPage;
		if(totalRecord%numPerPage != 0)
			this.totalPage++;
		*/
		this.totalPage = (int) Math.ceil((double)totalRecord/numPerPage);
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

}









