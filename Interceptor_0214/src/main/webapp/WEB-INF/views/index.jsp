<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" 
		href="resources/css/common.css"/>
<link rel="stylesheet" type="text/css" 
		href="resources/css/main.css"/>
</head>
<body>
	<div id="wrap">
		<!-- ===== 상단영역 ===== -->
		<jsp:include page="nav.jsp"/>
		<!-- ===== 상단영역 끝 ===== -->
		
		<!-- ===== 콘텐츠영역 ===== -->
		<div id="contents">
			<div class="main_img">
				<a href="">
					<img src="resources/img/@img00.png" 
					alt="메인공고이미지"/>
				</a>
			</div>
			<div class="main_news">
				<div class="news_type01 fl">
					<p class="title">기브유 후원참여</p>
					<a href="" class="news_src">
						<span class="thum_img">
							<img src="resources/img/@img01.png"
							alt="기사사진1"/>
						</span>
						<span class="subject ellip">
							난청이지만 피아니스트가 되고픈 한별이의 이야기입니다.
						</span>
					</a>
					<div>
						<span class="writer">by ttogether</span>
						<span class="more_view">자세히보기</span>
					</div>
				</div>
				<div class="news_type01 fc">
					<p class="title">기브유 후원금 쓰임현황</p>
					<a href="" class="news_src">
						<span class="thum_img">
							<img src="resources/img/@img02.png"
							alt="기사사진2"/>
						</span>
						<span class="subject ellip">
							레티하씨 가정에 희망의 집 선물로 행복한 꿈이 시작
						</span>
					</a>
					<div>
						<span class="writer">by 한국좋은모임</span>
						<span class="more_view">자세히보기</span>
					</div>
				</div>
				<div class="news_type01 fr">
					<p class="title">기브유 나눔영상</p>
					<a href="https://www.youtube.com/watch?v=5_EuQYmpP-A" class="news_src">
						<span class="thum_img">
							<img src="resources/img/@img03.png"
							alt="기사사진3"/>
							<!-- 플레이 버튼을 위한 태그 -->
							<span id="btn_play" 
									title="동영상 재생">
								<a href=""></a>
							</span>
						</span>
						<span class="subject ellip">
							생수 1리터의 생명을 선물해 주세요
						</span>
					</a>
					<div>
						<span class="writer">by hungersaver</span>
						<span class="more_view">자세히보기</span>
					</div>
				</div>
			</div>
			
			<div class="main_board">
				<!-- 공지사항 -->
				<div class="board_type01 fl">
					<p class="title">공지사항</p>
					<span class="more_view">
						<a href="">더보기</a>
					</span>
					<ul class="notice">
						<li>
							<a href="" class="ellip">
								T-together리누얼 오픈되었습니다.
							</a>
							<span class="date">2024.04.29</span>
						</li>
						<li>
							<a href="" class="ellip">
								GiveU이벤트 당첨자 공지입니다.
							</a>
							<span class="date">2024.04.26</span>
						</li>
						<li>
							<a href="" class="ellip">
								앞으로 코딩의 활용분야 범위는 우리 생활 모두가 될것이다.
							</a>
							<span class="date">2024.04.25</span>
						</li>
					</ul>
				</div>
				<!-- 공지사항 끝 -->
				
				<!-- together트위터 -->
				<div class="board_type01 fc">
					<p class="title">T-togheter트위터</p>
					<span class="more_view">
						<a href="">더보기</a>
					</span>
					<article>
						<span class="thum_img">
							<img src="resources/img/@img04.png" 
							alt="기사이미지"/>
						</span>
						<span class="src">
							[캠페인] 뜨거웠던 여름이 지나가고
							시원한 바람과 RGB색상이 흔들던
							나무들도 사라지고 차가운 바람의 겨울이
						</span>
					</article>
				</div>
				<!-- together트위터 끝 -->
				
				<!-- 배너 -->
				<div class="board_type01 fr">
					<span class="banner b01">
						<a href="">배너1</a>
					</span>
					<span class="banner b02">
						<a href="">배너2</a>
					</span>
				</div>
				<!-- 배너 끝 -->
			</div>
		</div>
		<!-- ===== 콘텐츠영역 끝 ===== -->
		
		<!-- ===== 하단영역 ===== -->
		<footer id="footer">
			<div class="footer_area">
				<ul class="footer_guide">
					<li><a href="">개인정보처리방침</a></li>
					<li><a href="">회원이용약관</a></li>
					<li><a href="">명의도용 방지서비스</a></li>
					<li><a href="">이메일 부단 수집거부</a></li>
				</ul>
				<address>
					서울특별시 강남구 테헤란로 132(역삼동) 한독약품빌딩 8층
					대표이사 : 이도
					고객상담: 국번없이 114 혹은 01-2223-3453 
				</address>
				<p class="copyright">
					Copyright &copy; 2024 SK Telecom. All rights reserved
				</p>
			</div>
		</footer>
		<!-- ===== 하단영역 끝 ===== -->
	</div>
</body>
</html>