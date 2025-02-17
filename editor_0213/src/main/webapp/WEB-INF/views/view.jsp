<%@ page import="mybatis.vo.BbsVO" %>
<%@ page import="mybatis.vo.CommVO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.14.1/themes/base/jquery-ui.css">
    <style type="text/css">
        #bbs table {
            width:580px;
            margin-left:10px;
            border:1px solid black;
            border-collapse:collapse;
            font-size:14px;

        }

        #bbs table caption {
            font-size:20px;
            font-weight:bold;
            margin-bottom:10px;
        }

        #bbs table th {
            text-align:center;
            border:1px solid black;
            padding:4px 10px;
        }

        #bbs table td {
            text-align:left;
            border:1px solid black;
            padding:4px 10px;
        }

        .no {width:15%}
        .subject {width:30%}
        .writer {width:20%}
        .reg {width:20%}
        .hit {width:15%}
        .title{background:lightsteelblue}

        .odd {background:silver}

        .hide{display: none;}

    </style>

</head>
<body>
<c:if test="${requestScope.vo ne null}">
    <c:set var="vo" value="${requestScope.vo}"/>
    <div id="bbs">
        <form method="post" >
            <table summary="게시판 글쓰기">
                <caption>게시판 글쓰기</caption>
                <tbody>
            <tr>
                <th>제목:</th>
                <td>${vo.subject}</td>
            </tr>

                <c:if test="${vo.file_name != null and vo.file_name.length() > 4}">
                    <tr>
                        <th>첨부파일:</th>
                        <td><a href="javascript:down('${vo.file_name}')">
                            ${vo.file_name}
                        </a></td>
                    </tr>
                </c:if>
            <tr>
                <th>이름:</th>
                <td>${vo.writer}</td>
            </tr>
            <tr>
                <th>내용:</th>
                <td>${vo.content}</td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="button" value="수정" onclick="goEdit()"/>
                    <input type="button" value="삭제"/>
                    <input type="button" value="목록" onclick="goList()"/>
                </td>
            </tr>
            </tbody>
        </table>
    </form>

    <form method="post" action="Controller">
        <input type="hidden" name="type" value="comm"/>
        이름:<input type="text" name="writer"/><br/>
        내용:<textarea rows="4" cols="55" name="comm"></textarea><br/>
        비밀번호:<input type="password" name="pwd"/><br/>


        <input type="hidden" name="b_idx" value="${vo.b_idx}">
        <input type="hidden" name="cPage" value="${requestScope.cPage}"/>
        <input type="button" value="저장하기"/>
    </form>
    <form name="frm" method="post">
        <input type="hidden" name="type"/>
        <input type="hidden" name="f_name"/>
        <input type="hidden" name="b_idx" value="${vo.b_idx}"/>
        <input type="hidden" name="cPage" value="${requestScope.cPage}"/>
    </form>

        <%-- 삭제시 보여주는 팝업창  --%>
    <div id="del_dialog" title="삭제" class="hide">
        <form action="Controller" method="post">
            <label>비밀번호 : </label>
            <input type="password" id="pwd" name="pwd" size="10"/>
            <br/><br/>

            <input type="hidden" name="type" value="del"/>
            <input type="hidden" name="b_idx" value="${vo.b_idx}"/>
            <input type="hidden" name="cPage" value="${requestScope.cPage}"/>
            <input type="button" value="삭제" onclick="delBbs(this.form)"/>

        </form>
    </div>
        <%-- 삭제시 보여주는 팝업창 끝  --%>

    댓글들<hr/>
    <c:forEach var="cvo" items="${vo.c_list}">
        <div>
            이름:${cvo.writer} &nbsp;&nbsp;
            날짜:${cvo.write_date}<br/>
            내용:${cvo.content}
        </div>
    </c:forEach>
</div>
</c:if>
<c:set var="obj" value="${requestScope.vo}"/>
<c:if test="${obj eq null}">
    <c:redirect url="Controller">
        <!-- Controller?type=list&cPage=2 이런식으로 가게된다.-->
        <c:param name="type" value="list"/>
       <c:param name="cPage" value="1"/>
    </c:redirect>
</c:if>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.14.1/jquery-ui.js"></script>
    <script>
        function goList() {
            //현재 문서안에 이름이 frm인 폼객체의 action을 Controller로 지정한다.
            document.frm.action = "Controller";
            document.frm.type.value = "list"; //<input type="hidden" name="type" value="list"/>와 같아진다.
            document.frm.submit();
        }

        function goEdit(){
            document.frm.action = "Controller";
            document.frm.type.value = "edit"; //<input type="hidden" name="type" value="edit"/>와 같아진다.
            document.frm.submit();
        }

        function goDel(){
/*
            if(confirm("정말 삭제하시겠습니까?")){ //참 거짓만 반환함.
            document.frm.action = "Controller";
            document.frm.type.value = "del"; //<input type="hidden" name="type" value="del"/>와 같아진다.
            document.frm.submit();
            }
 */
            $("#del_dialog").dialog(); //대화 팝업창 보여주기.
        }

        function delBbs(frm){
            let pwd = $("#pwd").val().trim();
            if(pwd.length < 1) {
                alert("비밀번호를 입력하세요.");
                $("#pwd").val("");
                $("pwd").focus();
                return;
            }
            frm.submit(); // 컨트롤러를 거쳐서 DelAction으로 간다.
        }

        function down(fname){
            document.frm.action = "download.jsp";
            document.frm.f_name.value = fname;
            document.frm.submit();
        }
    </script>
</body>
</html>













