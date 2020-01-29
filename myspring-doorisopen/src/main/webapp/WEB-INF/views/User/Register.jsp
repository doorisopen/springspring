<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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