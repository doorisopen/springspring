<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello Spring Spring world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<!-- 
<video width="80%" src="resources/demovideo.MP4" loop></video>
<div>Let's Go Board</div>
 -->
<div style="margin: 20px;"><a href="/myspring/Board/boardRead">게시글 리스트 가기</a></div>
<div style="margin: 20px;"><a href="/myspring/Goods/goodsRead">상품 리스트 가기</a></div>

<script>
function agree_check() {
	if(document.frm.agree1.value == "no") {
		alert("약관1에 동의하세요");
   		return false;
	}
	if(document.frm.agree2.value == "no") {
	   alert("약관2에 동의하세요");
	   return false;
	}
	if(document.frm.agree1.value == "yes" && document.frm.agree2.value == "yes") {
		alert("success");
		return true;
	}
   // document.frm.submit();
   }
</script>


<h3> 회원가입</h3>
<form name="frm" action="#" method="post">
<input type="radio" name="agree1" value="yes"/>동의
<input type="radio" name="agree1" value="no" checked/>동의안함<p>
<input type="radio" name="agree2" value="yes"/>동의
<input type="radio" name="agree2" value="no" checked/>동의안함<p>
<input type="button" value="회원가입" onclick="agree_check()"/>
</form>


</body>
</html>
