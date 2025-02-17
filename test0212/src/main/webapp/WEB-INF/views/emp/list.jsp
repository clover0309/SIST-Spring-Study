<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>사원정보</h1>
<table border="1">
    <thead>
    <tr>
        <th>사번</th>
        <th>이름</th>
        <th>직업</th>
        <th>매니저</th>
        <th>입사일</th>
        <th>월급</th>
        <th>연봉</th>
        <th>부서번호</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="vo" items="${empList}" varStatus="">
        <tr>
            <td>${vo.empno}</td>
            <td>${vo.ename}</td>
            <td>${vo.job}</td>
            <td>${vo.mgr}</td>
            <td>${vo.hiredate}</td>
            <td>${vo.sal}</td>
            <td>${vo.comm}</td>
            <td>${vo.deptno}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
