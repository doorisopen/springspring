<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/board.css">


<script>

</script>
<title>DOOP</title>
</head>
<body>
	<!-- div center -->
	<div align=center>
	 <header>게시글 리스트</header>
 
	 	<!-- Board List -->
		<table border="1">
			<thead>
				<tr>
					<th colspan="2">NO</th>
					<th colspan="10">Title</th>
					<th colspan="5">Writer</th>
					<th colspan="5">WriteDate</th>
					<th colspan="2">View</th>
				</tr>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${fn:length(boardRead) > 0}">
					<c:forEach items="${boardRead }" var="boardRead" varStatus="rowcnt">
						<tr>
							<td colspan="2">${boardRead.boardIdx}</td>
							<td colspan="10"><a href="/myspring/Board/boardDetail?boardIdx=${boardRead.boardIdx}">${boardRead.boardTitle}</a></td>
							<td colspan="5">${boardRead.writer}</td>
							<td colspan="5">${boardRead.writeDate}</td>
							<td colspan="2">${boardRead.boardViewCnt}</td>
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
		<!-- pagination{s} -->

		<div class="paginationBox">
			<ul class="pagination">
				<c:if test="${pagination.prev}">
					<li class="page-item"><a class="page-link" href="#"
						onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a></li>
				</c:if>

				<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
					<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> ">
						<a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')">
							${idx}
						</a>
					</li>
				</c:forEach>

				<c:if test="${pagination.next}">
					<li class="page-item"><a class="page-link" href="#"
						onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')">Next</a>
					</li>
				</c:if>
			</ul>
		</div>
		<!-- pagination{e} -->

		<div>
			<a href="/myspring/Board/boardCreateView">게시글 등록하기</a>
		</div>
		
	</div>
	<!-- ./div center -->
</body>
<script src="../resources/js/pagination.js"></script>
</html>