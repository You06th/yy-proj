<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<body>
	<div>
		<h4>영상 보여줄 태그</h4>
	</div>
<script>
	$(function(){
		$.ajax({
			url : "playVideo.do",
			method:"POST",
			dataType:"json",
			success:function(result){
				console.log(result)
				menuAjax_result_fn(result);
			}
		})
	})
</script>
</body>
</html>