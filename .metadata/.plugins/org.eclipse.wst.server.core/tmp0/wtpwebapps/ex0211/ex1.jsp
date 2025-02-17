<%@page import="ex1.vo.TestVO"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.beans.factory.BeanFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//준비된 환경설정 파일(config.xml)을 로드한다.
	//여기서 config.xml에 만들어둔 bean들이 다 생성된다.
	BeanFactory bf = new ClassPathXmlApplicationContext("config.xml");
	
	//사용자가 원하는 bean객체를 얻어내자(id가 t1인 객체)
	//여기서는 Object로 받기 때문에, 캐스팅을 해줘야함.
	TestVO tt = (TestVO) bf.getBean("t1");
%>

	<h1><%=tt.getMsg()%></h1>
</body>
</html>