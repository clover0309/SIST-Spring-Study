<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        #t1{
            border-collapse: collapse;
            width: 400px;
        }
        #t1 caption{
            text-indent: -9999px;
            height: 0;
        }
        #t1 th{
            padding: 6px;
            background-color: #dedede;
            border: 1px solid black;
        }
        #t1 td{
            padding: 4px;
            border: 1px solid black;
        }
        #t1 .no-border{ border: none; }
        #type, #value, #btn1{
            padding: 5px;
        }
        .w150{ width: 150px; }

    </style>
</head>
<body>
<h1>회원 목록</h1>
<hr/>
<table id="t1">
    <caption>회원목록테이블</caption>
    <thead>
    <tr>
        <td colspan="3" class="no-border">
            <form action="search" method="post">
                <select id="type">
                    <option value="0">이름</option>
                    <option value="1">이메일</option>
                    <option value="2">연락처</option>
                </select>
                <input type="text" id="value"
                       class="w150"/>
                <button type="button" id="btn1">
                    검색
                </button>
            </form>
        </td>
    </tr>
    <tr>
        <th>회원명</th>
        <th>이메일</th>
        <th>전화번호</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ar }" var="vo">
        <tr>
            <td>${vo.name }</td>
            <td>${vo.email }</td>
            <td>${vo.phone }</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
    $(function(){

        $("#btn1").click(function(){

            let type = $("#type").val();
            let value = $("#value").val();

            if(value.trim().length < 1){
                alert("검색어를 입력하세요");
                $("#value").focus();
                return;
            }

            $.ajax({
                url: "search",
                data: {
                    "searchType": type,
                    "searchValue": value,
                }, //서버로 보내고자 하는 인자
                type: "post", //서버요청 방식
                dataType: "json",//서버로부터 전달되어 오는
                // 자원의 자료형
            }).done(function(data){
                let str = "";
                if(data.ar != null && data.count > 0){
                    for(let i=0; i<data.count; i++){
                        if(data.ar[i] != null){
                            str += "<tr onclick='viewData(this)'><td>";
                            str += data.ar[i].name;
                            str += "</td><td>";
                            str += data.ar[i].email;
                            str += "</td><td>";
                            str += data.ar[i].phone;
                            str += "</td></tr>";
                        }
                    }//for의 끝
                }else{
                    str = "<tr><td colspan='3'>검색된 결과가 없습니다.</td></tr>";
                }
                $("#t1 tbody").html(str);
            });
        });
    });


</script>
</body>
</html>







