<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
</head>
<style>
	#file-frm{width:700px; border:1px solid lightgray;}
	.mb-3{padding:10px}
	#filebox .upload-name {
	    display: inline-block;
	    height: 40px;
	    padding: 0 10px;
	    vertical-align: middle;
	    border: 1px solid #dddddd;
	    width: 78%;
	    color: #999999;
	}
	#filebox label {
    display: inline-block;
    padding: 10px 10px;
    color: #fff;
    vertical-align: middle;
    background-color: #999999;
    cursor: pointer;
    height: 25px;
    margin-left: 10px;
	}
	#filebox input[type="file"] {
    position: absolute;
    width: 0;
    height: 0;
    padding: 0;
    overflow: hidden;
    border: 0;
	}
	.txt-input{
    font-family: 'Noto Sans KR','Noto Sans Korean', "Nanum Gothic", sans-serif !important;
    -webkit-appearance: none;
    -webkit-border-radius: 0;
    border: 0;
    outline: none;
    font-size: 10px;
	}
	.txt-input::placeholder{
  	color: #d9d9d9
	}
	.textbox{
	  width: 100%; 
	  box-sizeing: border-box;
	  position: relative;
	}
	.textbox label{
	  display: inline-block;
	  position: absolute;
	  top: -5px;
	  left: 14px;
	  padding: 10px;
	  background: white;
	  font-size: 14px;
	  color: #888;
	  font-weight: bold;
	}
	.textbox.ver2 label{
	  top: initial;
	  bottom: -20px;
	}
	.textbox label span{
	  color: #da4841;
	  vertical-align: -1px;
	}
	.textbox input{
	    width: 100%;
	    border: 1px solid #dddddd !important;
	    font-size: 1rem;
	    line-height: 1.45;
	    letter-spacing: -0.04rem;
	    border-radius: 8px;
	    padding: 16px;
	    margin-top: 12px;
	}
	#preview{
		display:inline-block;
		width:700px;
		height:700px;
		border:1px solid black;
	}
</style>
<body>
	<h2>추가</h2>
	
	<form name="file-frm" id="file-frm" method="post" enctype="multipart/form-data">
	  <div id="preview">
			<video id="videoPlay" width="600px" height="600px" controls autoplay> 
				<source type="video/mp4" src="" type="video/mp4" />
				<source src="mov_bbb.ogg" type="video/ogg">
			</video>
	  </div>
	
	  <div class="mb-3" id="filebox">
	  	<input class="upload-name" value="첨부파일" placeholder="첨부파일">
	    <label for="video" class="form-label">추가</label>
	    <input type="file" class="form-control" id="video" name="video" placeholder="mp4만 가능합니다.">
	  </div>
	  <div class="mb-3" style="display:flex; flex-direction:column; width:500px;">
	  	<div class="textbox">
		  	<label for="title"><span>* </span>제목</label>
		    <input type="text" class="txt-input" id="title" name="title">
	    </div>
	    <div class="textbox">
		    <label for="content"><span>* </span>내용</label>
		    <input type="text" class="txt-input" id="content" name="content">
		</div>
	  </div>
<!-- 	  <div class="mb-3">
	    <label for="thumbNail" class="form-label">썸네일 등록</label>
	    <input type="file" class="form-control" id="thumbNail" name="thumbNail">
	  </div> -->
	
	  <button type="submit" class="btn btn-primary" onclick="fileIUD('I');">등록</button>
	</form>
	
<script>

	$("#video").on('change',function(){
	 	 var fileName = $("#video").val();
	 	 var startIndex = fileName.lastIndexOf("\\")+1;
	 	 var lastIndex =  fileName.lastIndexOf(".");
	 	 var realFileNm = fileName.substring(startIndex, lastIndex); 
	 	 
	  	$(".upload-name").val(realFileNm);
	  	
	  	$("#videoPlay").attr("src",fileName);
	});
	function fileIUD(IUD){
		
		  var data = new FormData($('#file-frm')[0]);
	    
		  data.append("IUD",IUD)
	         $.ajax({
	             url : "insVideo.do"
	           , type : "POST"
	           , processData : false
	           , contentType : false
	           , data : data
	           , success:function(response) {
	               alert("성공하였습니다.");
	               console.log(data);
	           }
	           ,error: function (jqXHR) 
	           { 
	               alert(jqXHR.responseText); 
	           }
	         })
	} 
</script>
</body>
</html>