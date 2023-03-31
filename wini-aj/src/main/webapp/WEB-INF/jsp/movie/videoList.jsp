<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!--JQUERY-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!--bootstrap-->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
	<div id="list-wrap">
		
	</div>
	
<script>
	$(function(){
		listGrid();
	})
	
	function listGrid(){
		$.ajax({
			url : "videoList.do",
			method:"POST",
			dataType:"json",
			success:function(result){
				console.log(result)
				ajax_result_fn(result);
			}
		})
	}
	
	function ajax_result_fn(result){
		console.log("videoInfo",result.videoList)
		var resultList = result.videoList;
		
		var appendTag = '<div class="card" style="width: 18rem;">'
		
		for(i=0; i<resultList.length; i++){
			appendTag += '<input type="hidden" value="'+ resultList[i].boardId +'">' 
			appendTag += '<img class="card-img-top" src="'+ resultList[i].savePath +'/'+resultList[i].orgNm +'" alt="Card image cap">'
			appendTag += '<video id="videoPlay" width="700" height="600" controls autoplay> <source type="video/mp4" src="'+ resultList[i].vSavePath +'/'+resultList[i].vOrgNm +'" type="video/mp4" /><source src="mov_bbb.ogg" type="video/ogg"></video>'
			appendTag += '<div class="card-body">'+ resultList[i].title +'</div>'
			appendTag += ' </div>'
			
		}
		$('#list-wrap').html(appendTag);
 	
	}
</script>
</body>
</html>