<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <header>
        <h2>추가정보 입력</h2>
    </header>
    <form action="/register" method="post">
        <img src="${mvo.p_img}" width = "100"/><br/>
        이름: <input type="text" name="m_name"/><br/>
        별칭: <input type="text" name="nickname" readonly
        value="${mvo.nickname}"/><br/>
        이메일: <input type="text" name="m_email"/><br/>
        연락처: <input type="text" name="m_phone"/><br/>
        <button type="button">저장</button>
    </form>
</body>
</html>
