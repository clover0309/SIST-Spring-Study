<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="resources/css/common.css">
<link type="text/css" rel="stylesheet" href="resources/css/reg2.css">
</head>
<body>
<div id="wrap">
<!-- 상단영역 -->
	<jsp:include page="nav.jsp"/>
<!-- 상단영역 끝 -->
<!-- 콘텐츠영역 -->
	<div id="contents_sub">
		<h1 class="sub_title title01">일반 개인회원가입</h1>
		<p class="title_src">
			사회공헌 포탈 서비스인 T-together는 
			누구나 참여할 수 있으며 가입하시면 
			GiveU(기부)나 자원봉사 참여 등 
			다양한 서비스 이용이 가능합니다.
			이용 프로그램에 따라 필요한 
			추가정보를 요청할 수 있습니다.			
		</p>
		<p class="guide_txt">
			기본회원정보를 입력해 주세요
			<span class="fr guide_txt">
			  <span class="req"></span>
			  필수입력사항
			</span>
		</p>
		<br/>
		
		<!-- 회원가입 폼테이블 영역  -->
		<table class="table_type01" 
		style="width: 900px">
			<colgroup>
				<col width="130px">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>
					 <!-- <span class="noreq"></span> -->
					이름</th>
					<td>마루치</td>
				</tr>
				<tr>
					<th>
					 <span class="req"></span>
					 아이디
					</th>
					<td>
					  <p class="guide_txt">
					   6~12자리의 영문, 숫자(혼용가능)를 입력해 주세요.
					  </p>
					  <p>
					   <label for="s_id" class="hidden">아이디</label>
					   <input type="text" name="" id="s_id"
					    class="join"/>
					    <span class="btn b_bdcheck">
					    	<a href="">중복확인</a>
					    </span>
					  </p>
					</td>
				</tr>
				<tr>
					<th>
					  <span class="req"></span>
					  비밀번호
					</th>
					<td>
					  <p class="guide_txt">
					   안전을 위해 10개 이상의 문자조합(
					   영문 대소문자 + 숫자 또는 기호(!~#@))를 
					   입력해 주세요.
					  </p>
					  <p>
					   <label for="s_pw" class="hidden">비밀번호</label>
					   <input type="password" name="" id="s_pw"
					    class="join"/>					    
					  </p>
					</td>
				</tr>
				<tr>
					<th>
					  <span class="req"></span>
					  비밀번호 확인
					</th>
					<td>
					  <p class="guide_txt">
					   입력하신 비밀번호 확인을 위해 
					   다시한번 입력해 주세요.
					  </p>
					  <p>
					   <label for="s_pw2" class="hidden">비밀번호확인</label>
					   <input type="password" name="" id="s_pw2"
					    class="join"/>					    
					  </p>
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<p>
						
							<input type="text" id="postcode" placeholder="우편번호">
							<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class ="btn postcheck"><br>
							<input type="text" id="roadAddress" placeholder="도로명주소">
							<input type="text" id="jibunAddress" placeholder="지번주소">
							<span id="guide" style="color:#999"></span>
						
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<div class="caution1 t_2">
							<p class="txt caution_txt">* 이메일은 T-together 활동에 필요한 정보를 받기 위해 필요합니다.</p>
							<input type="text" value="" class="type3" title="이메일 아이디 입력" name="email1" id="email1" style="vertical-align: middle;"/> @
							<input type="text" value="" title="이메일 도메인 입력" name="email2" id="email2"  disabled="disabled" style="vertical-align: middle;"/>
							<div id ="d1">
								<div id ="d2">	
									<select title="이메일 도메인 선택" class="type1" name="emailList" id="emailList" >
										<option value="">선택하세요</option>
										<option value="naver.com">naver.com</option>
										<option value="nate.com">nate.com</option>
										<option value="hanmail.net">hanmail.net</option>
										<option value="gmail.com">gmail.com</option>
										<option value="hotmail.com">hotmail.com</option>
										<option value="yahoo.co.kr">yahoo.co.kr</option>
										<option value="empas.com">empas.com</option>
										<option value="dreamwiz.com">dreamwiz.com</option>
										<option value="freechal.com">freechal.com</option>
										<option value="lycos.co.kr">lycos.co.kr</option>
										<option value="korea.com">korea.com</option>
										<option value="hanmir.com">hanmir.com</option>
										<option value="paran.com">paran.com</option>
										<option value="cholian.net">cholian.net</option>
										<option value="hanafos.com">hanafos.com</option>
										<option value="self">직접입력</option>
									</select>
								</div>
							</div>	
						</div>
					</td>
				</tr>
								
				<tr>
					<th>
					<!-- <span class="noreq"></span> -->
					관심기부대상</th>
					<td>
					  <input type="checkbox" 
					  name="give" id="ch01"/>
					  <label for="ch01">아동</label>
					  &nbsp;
					  <input type="checkbox" 
					  name="give" id="ch02"/>
					  <label for="ch02">노인</label>
					  &nbsp;
					  <input type="checkbox" 
					  name="give" id="ch03"/>
					  <label for="ch03">건강</label>
					  &nbsp;
					  <input type="checkbox" 
					  name="give" id="ch04"/>
					  <label for="ch04">학습</label>
					  &nbsp;
					  <input type="checkbox" 
					  name="give" id="ch05"/>
					  <label for="ch05">문화</label>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="btn_center">
			<p class="btn b_confirm">
				<a href="#" onclick="formval();">확인.</a>
			</p>
			<p class="btn b_cancel">
				<a href="#">취소.</a>
			</p>
		</div>
		<!-- 회원가입 폼테이블 영역  끝-->
	</div>
<!-- 콘텐츠영역 끝 -->	
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