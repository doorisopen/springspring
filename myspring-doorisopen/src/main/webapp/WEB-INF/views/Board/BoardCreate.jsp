<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOOP</title>
</head>
<body>
	<div align=center>
	 <header>게시글 등록하기</header>
		<form action="/myspring/BoardCreate" method="POST">
			<table>
				<tr>
					<th>게시글 제목</th>
					<td><input type="text" name="boardTitle" autofocus placeholder="공백없이 입력하세요"/></td>
				</tr>
				<tr>
					<th>게시글 내용</th>
					<td><input type="text" name="boardContent" placeholder="공백없이 입력하세요"/></td>
				</tr>
				<tr>
					<th>게시글 작성자</th>
					<td><input type="text" name="writer" placeholder="공백없이 입력하세요"/></td>
				</tr>
			</table>
			<div>
				<input type="submit" name="submit" value="등록" />
				<input type="reset" name="reset" value="재 작성" />
			</div>
		</form>	
	</div>
</body>
</html>