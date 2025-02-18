<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
  <style>
    table{
      width: 600px;
      border-collapse: collapse;
    }
    table th, table td{
      border:1px solid #000;
      padding: 4px;
    }
    table caption {
      text-indent: -9999px;
      height: 0px;
    }
  </style>
</head>
<body>
<div id="wrap">
  <header>
    <h1>행사목록</h1>
  </header>
  <article>
    <table>
      <caption>행사목록테이블</caption>
      <colgroup>
        <col width="40px"/>
        <col width="100px"/>
        <col width="150px"/>
        <col width="*"/>
      </colgroup>
      <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>전화</th>
        <th>주소</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="vo" items="${requestScope.ar }" varStatus="st">
        <tr>
          <td>${st.index+1}</td>

          <td>${vo.title}</td>

          <td>${vo.tel}</td>

          <td>${vo.addr1} &nbsp;  ${vo.addr2}</td>

        </tr>
      </c:forEach>
      </tbody>
    </table>
    <h2>내용 추가 1</h2>
    <h2>내용 추가 2</h2>
  </article>
</div>
</body>
</html>
