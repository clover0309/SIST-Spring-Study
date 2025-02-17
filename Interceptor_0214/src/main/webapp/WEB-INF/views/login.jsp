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
		href="resources/css/login.css"/>
</head>
<body>
	<div id="wrap">
		<!-- ===== 상단영역 ===== -->
		<jsp:include page="nav.jsp"/>
		<!-- ===== 상단영역 끝 ===== -->
		
		<!-- ===== 콘텐츠영역 ===== -->
		<div id="contents">
			<h1 class="sub_title tit02">회원 로그인</h1>
			<div class="login_area">
				<!-- 일반회원로그인 -->
				<div class="person_login">
					<h2 class="sub_title title01">개인회원</h2>
					<div class="login">
						<form action="login" method="post" name="frm1">
							<div class="input_area">
								<p>
									<label for="s_id">아이디</label>
									<input type="text" id="s_id"
										name="m_id"/>
								</p>
								<p>
									<label for="s_pw">비밀번호</label>
									<input type="password" 
										id="s_pw" name="m_pw"/>
								</p>
							</div>
							<div class="btn_area">
								<span class="btn b_login">
									<a href="javascript:login()">로그인</a>
								</span>
							</div>
							<p class="login_search">
								<input type="checkbox" 
									name="chk" id="ch01"/>
								<label for="ch01">아이디저장</label>
								<span class="btn b_search">
									<a href="">아이디/비밀번호찾기</a>
								</span>
							</p>
						</form>
					</div>
				</div>				
				
				<!-- 단체회원로그인 -->
				<div class="group_login">
					<h2 class="sub_title title02">개인회원</h2>
					<div class="login">
						<form action="" method="post">
							<div class="input_area">
								<p>
									<label for="s_id">아이디</label>
									<input type="text" id="s_id"
										name="m_id"/>
								</p>
								<p>
									<label for="s_pw">비밀번호</label>
									<input type="password" 
										id="s_pw" name="m_pw"/>
								</p>
							</div>
							<div class="btn_area">
								<span class="btn b_login">
									<a href="">로그인</a>
								</span>
							</div>
							<p class="login_search">
								<input type="checkbox" 
									name="chk" id="ch01"/>
								<label for="ch01">아이디저장</label>
								<span class="btn b_search">
									<a href="">아이디/비밀번호찾기</a>
								</span>
							</p>
						</form>
					</div>
				</div>
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
		function login(){
			//유효성 검사
			
			document.frm1.submit();
		}		
	</script>
</body>
</html>



