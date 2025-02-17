<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
  <h2>게시글 목록</h2>
  <hr/>
  <ul>
  <c:forEach var="vo" items="${bbs_ar}" varStatus="vs">
    <li>${vo.subject} || ${vo.write_date}</li>
  </c:forEach>
  </ul>
</body>
</html>
