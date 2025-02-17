<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <header>
        <h1>로그인</h1>
    </header>

    <%--
     세션에 "mvo"라는 값이 없을 때는 로그인 화면이 나타나야 한다.
     --%>

    <c:if test="${sessionScope.mvo eq null}">
        <form action="" method="post">
            ID: <input type="text" name="m_id"/><br/>
            PW: <input type="password" name="m_pw"/><br/>
            <button type="button">LOGIN</button>
        </form>
        <a href="https://kauth.kakao.com/oauth/authorize?client_id=e3075c63df4a3c2135413cd116f067c5&redirect_uri=http://localhost:8080/login/kakao&response_type=code"/>
        <img src="/resources/images/kakao_login.png"/>
    </c:if>
</body>
</html>
