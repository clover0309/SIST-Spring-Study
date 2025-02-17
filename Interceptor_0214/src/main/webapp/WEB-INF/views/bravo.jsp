<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" 
		href="../resources/css/common.css"/>
<link rel="stylesheet" type="text/css" 
		href="../resources/css/sub_tab.css"/>
</head>
<body onload="test()">
	<div id="wrap">
		<!-- ===== 상단영역 ===== -->
		<jsp:include page="nav.jsp"/>
		<!-- ===== 상단영역 끝 ===== -->
		
		<!-- ===== 콘텐츠영역 ===== -->
		<div id="contents">
			<p>
				<img src="../resources/img/@img05.png" alt="서브페이지이미지"/>
			</p>
			<div class="tab_type01"> <!-- 탭바 영역 -->
				<ul>
					<li id="t1" class="selected">
						<a href="javascript:ex1(1)">위드유</a>
					</li>
					<li id="t2">
						<a href="javascript:ex1(2)">위드유 영상</a>
					</li>
					<li id="t3">
						<a href="javascript:ex1(3)">위드유 행사</a>
					</li>
				</ul>
			</div>
			<!-- 첫번째 탭의 내용 -->
			<div id="tab1" class="tab_cont show">
				잉글랜드 프리미어리그(EPL) 300경기 출전에 120골이라는 뜻깊은 기록을 
				세우고도 토트넘의 4연패를 막지 못한 손흥민은 웃지 못했습니다.<br/>
				토트넘은 영국 리버풀의 안필드에서 열린 2023-2024 EPL 
				36라운드 원정 경기에서 리버풀에 4대 2로 져 무려 20년 만에 
				4연패의 수렁에 빠졌습니다.<br/>

				최전방 공격수로 선발 출격해 토트넘 역사상 세 번째로 
				EPL 300경기 출전을 이룬 손흥민은 120번째 득점으로 
				리버풀의 전설 스티븐 제라드와 어깨를 나란히 했지만<br/> 
				고개를 숙인 채 경기장을 떠났습니다.<br/>

				손흥민은 경기 후 구단 공식 채널과 인터뷰에서 굳은 표정으로
				 "힘들고 실망스러운 오후"라며 "올 시즌 들어 처음으로 매우 
				 어려운 상황을 맞았다.<br/> 우린 그걸 마주해야 하고, 
				 더 나아지고 강해져야 한다"고 말했습니다.<br/>
			</div>
			
			<!-- 두번째 탭의 내용 -->
			<div id="tab2" class="tab_cont">
				이번 시즌 프리미어리그(PL) 우승팀은 토트넘 홋스퍼가 
				결정할 수도 있다.<br/>

				만약 토트넘이 오는 리그 37라운드 경기에서 맨체스터 시티를 꺾을
				 경우 20년 만의 우승에 도전하는 아스널이 
				 왕관을 쓸 가능성이 높아진다.<br/> 
				반대로 토트넘이 맨시티에 승점 3점을 내준다면 맨시티가 전무후무한 
				PL 4연패라는 대업적을 달성하는 모습을 볼 수도 있다.<br/>

				토트넘은 15일(한국시간) 영국 런던에 위치한 토트넘 홋스퍼 
				스타디움에서 맨시티와 2023-24시즌 
				PL 37라운드 경기를 치른다.<br/> 
				현재 토트넘은 승점 63점으로 리그 5위, 맨시티는 
				승점 85점으로 리그 2위에 위치해 있다.
			</div>
			
			<!-- 세번째 탭의 내용 -->
			<div id="tab3" class="tab_cont">
				토트넘이 ‘맞수’ 아스널의 공개 지지를 받았다. 
				아스널이 목 빠지게 기다린 잉글랜드 프리미어리그(EPL) 
				제패가 토트넘의 손에 달렸기 때문이다.<br/>

				토트넘은 15일 오전 4시(한국시간) 영국 런던 토트넘 홋스퍼 
				스타디움에서 맨체스터 시티와 2023~24 EPL 34라운드 
				홈 경기를 치른다.<br/>
				
				올 시즌 토트넘에 가장 중요성이 큰 승부라고 해도 과언이 아니다.
				 2경기를 남겨둔 토트넘(승점 63)은 한 경기 더 치른 4위 
				 애스턴 빌라(승점 68)를 5점 차로 추격 중이다.<br/> 
				토트넘은 남은 2경기에서 모두 이겨야 다음 시즌 
				유럽축구연맹(UEFA) 챔피언스리그(UCL) 진출을 기대할 수 있다. 
				<br/>다가오는 맨시티전이 중요한 이유다.  
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
	
	<script>
		//한줄 주석
		// 함수 정의 법: function이라는 단어를 사용함! function test(){}
	
		//자바스크립트에서는 변수를 선언할 때 
		//자료형을 지정하지 않는다.(값이 저장될 때 내부적으로 자료형이 지정 됨)
		let met = "Message";
		var su = 100;
		
		function test(){ // 이런 함수는 호출할 때만 수행한다.
			let ss = "AAAA";
			console.log(met +"/"+ ss +"/"+ su);
		}
		
		function ex1(num){
			//console.log("불려지나?"+num);
			
			//먼저 현재문서(document)에서 아이디가 t1인 요소를
			//검색하여 변수 t1에게 저장한다.
			let t1 = document.getElementById("t1");
			let t2 = document.getElementById("t2");
			let t3 = document.getElementById("t3");
			
			//t1에 지정된 class들을 모두 삭제하자!
			t1.className = "";
			t2.className = "";
			t3.className = "";
			
			//탭의 내용을 보여주는 tab1,tab2,tab3을 검색하자!
			let tab1 = document.getElementById("tab1");
			let tab2 = document.getElementById("tab2");
			let tab3 = document.getElementById("tab3");
			
			//각 탭들의 클래스를 초기화하자!
			tab1.className = "tab_cont";
			tab2.className = "tab_cont";
			tab3.className = "tab_cont";
			
			// 인자로 넘어온 num이 1이면 t1에게 
			//"selected"라는 클래스를 지정한다.
			switch(num){
				case 1:
					t1.className = "selected";
					tab1.className = "tab_cont show";
					break;
				case 2:
					t2.className = "selected";
					tab2.className = "tab_cont show";
					break;
				case 3:
					t3.className = "selected";
					tab3.className = "tab_cont show";
					break;
							
			}
		}
	</script>
</body>
</html>













