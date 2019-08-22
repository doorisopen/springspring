<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Result</title>
</head>
<body>
	<div align=center>
		<header>게시글 등록 결과</header>
		<c:if test="${board != null }">
			<table>
				<tr>
					<th>게시글 제목</th>
					<td><c:out value="${board.boardTitle}"/></td>
				</tr>
				<tr>
					<th>게시글 내용</th>
					<td><c:out value="${board.boardContent}"/></td>
				</tr>
				<tr>
					<th>게시글 작성자</th>
					<td><c:out value="${board.writer}"/></td>
				</tr>
			</table>
		
		
		</c:if>
	</div>
</body>
</html>