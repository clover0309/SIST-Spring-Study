<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/summernote-lite.css"/>
<style>
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
	
		
</style>

</head>
<body>
	<div id="bbs">
	<form action="write" method="post"
	encType="multipart/form-data">
		<table summary="게시판 글쓰기">
			<caption>게시판 글쓰기</caption>
			<tbody>

				<tr>
					<th>제목:</th>
					<td><input type="text" name="subject" id="title" size="45"/></td>
				</tr>
				<tr>
					<th>이름:</th>
					<td><input type="text" name="writer" id="write" size="12"/></td>
				</tr>
				<tr>
					<th>내용:</th>
					<td><textarea id="content" name="content" cols="50" 
							rows="8"></textarea></td>
				</tr>
				<tr>
					<th>첨부파일:</th>
					<td><input type="file" name="file"/></td>
				</tr>

				<tr>
					<th>비밀번호:</th>
					<td><input type="password" id="pwd" name="pwd" size="12"/></td>
				</tr>

				<tr>
					<td colspan="2">
						<input type="button" value="보내기"
						onclick="sendData()"/>
						<input type="button" value="다시"/>
						<input type="button" value="목록"/>
					</td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" name="bname" id="bname" value="BBS"/>
	</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script src="resources/js/summernote-lite.js"></script>
	<script src="resources/js/lang/summernote-ko-KR.js"></script>
	<script>
		$(function(){
			$("#content").summernote({
				lang:"ko-KR",
				callbacks:{
					onImageUpload: function(files, editor){
						// 이미지가 에디터에 추가될 때마다 수행하는 곳!!!!!!!!!
						//이미지를 첨부하면 배열로 인식된다.
						//이것을 서버로 비동기식 통신을 수행하면
						//서버에 업로드를 시킬 수 있다.
						for(let i=0; i<files.length; i++)
							saveImg(files[i], editor);
					}
				}
			});
		});
		
		function saveImg(file, editor){
			// 서버로 이미지를 보내기 위해 폼객체 준비
			let frm = new FormData();
			
			// 서버로 파일을 보내기 위해 폼객체에 파라미터를 지정
			frm.append("upload", file);
			
			//비 동기식 통신
			$.ajax({
				url: "saveImg",
				data: frm,
				type: "post",
				contentType: false,
				processData: false,// 첨부파일을 보내는 것이고, 일반적인 데이터 전송이 아님!
				dataType: "json"
			}).done(function(res){
				//서버에서 보내는 json데이터는 res가 되며, 그 res안에 img_url을 가지고
				//img요소를 에디터에 추가
				$("#content").summernote("editor.insertImage", res.url+"/"+res.fname);
			});
		}
		
		function sendData(){
			
			let title = $("#title").val();
			let writer = $("#writer").val();
			let content = $("#content").val();
			
			if(title.trim().length < 1){
				alert("제목을 입력하세요");
				$("#title").val("");//청소
				$("#title").focus();
				return;
			}
			
			document.forms[0].submit();
		}
	</script>
</body>
</html>












    