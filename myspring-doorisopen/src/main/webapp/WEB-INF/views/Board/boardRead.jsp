<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOOP</title>
</head>
<body>
	<!-- div center -->
	<div align=center>
	 <header>게시글 리스트</header>
 
	 	<!-- Board List -->
		<table>
			<thead>
				<tr>
					<th>NO</th>
					<th>Title</th>
					<th>Writer</th>
					<th>WriteDate</th>
				</tr>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${fn:length(boardRead) > 0}">
					<c:forEach items="${boardRead }" var="boardRead" varStatus="rowcnt">
						<tr>
							<td>${boardRead.boardIdx}</td>
							<td><a href="/myspring/Board/boardDetail?boardIdx=${boardRead.boardIdx}">${boardRead.boardTitle}</a></td>
							<td>${boardRead.writer}</td>
							<td>${boardRead.writeDate}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="6">조회된 결과가 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
			</tbody>
		</table>
		<!-- ./Board List -->
		<div>
			<a href="/myspring/Board/boardCreateView">게시글 등록하기</a>
		</div>
		
	</div>
	<!-- ./div center -->
</body>
</html>