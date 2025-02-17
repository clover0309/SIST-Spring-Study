<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>

    <h1>사원 목록</h1>
    <hr/>
    <ul>
        <c:forEach var="vo" items="${ar}">
            <li>${vo.empno} / ${vo.ename} / ${vo.job} /${vo.hiredate} / ${vo.deptno}</li>
        </c:forEach>
    </ul>
</body>
</html>
