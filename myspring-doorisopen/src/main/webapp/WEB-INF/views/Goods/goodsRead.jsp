<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOOP</title>
<link rel="stylesheet" href="../resources/css/goods.css">
</head>
<body>
	<!-- div center -->
	<div align=center>
	 <header><h1>상품 리스트</h1></header>
 		<a href="/myspring">^홈으로^</a>||
 		<a href="/myspring/Cart/cartRead">^장바구니( # 개)^</a>
	 	<!-- Goods List -->
		 <section>
			<article>
				<c:choose>
					<c:when test="${fn:length(goodsRead) > 0}">
						<c:forEach items="${goodsRead }" var="goodsRead" varStatus="rowcnt">
							<div class="img">
								<a href="/myspring/Goods/goodsDetail?goodsIdx=${goodsRead.goodsIdx}">
									<c:choose>
										<c:when test="${fn:length(goodsRead.goodsFilePath) > 0}">
											<img src="${pageContext.request.contextPath }${goodsRead.goodsFilePath}" width="350px" height="250px">
										</c:when>
										<c:otherwise>	
											등록된 사진이 없습니다.
										</c:otherwise>
									</c:choose>
									<div class="desc">번호: ${goodsRead.goodsIdx}</div>
									<div class="desc">제목: ${goodsRead.goodsTitle}</div>
									<div class="desc">등록자: ${goodsRead.writer}</div>
									<div class="desc">등록일자: ${goodsRead.writeDate}</div>
									<div class="desc">조회수: ${goodsRead.goodsViewCnt}</div>
									<div class="desc">리뷰수: ${goodsRead.goodsReplyCnt}</div>
								</a>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6">조회된 결과가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
				
				
				
			</article>
		</section>
		<!-- ./Goods List -->
		
		<!-- TABLE FORM
		
		<table border="1">
			<thead>
				<tr>
					<th colspan="2">NO</th>
					<th colspan="10">Title</th>
					<th colspan="5">Writer</th>
					<th colspan="5">WriteDate</th>
					<th colspan="2">View</th>
					<th colspan="2">Reply</th>
				</tr>
			</thead>
			<tbody>
			<c:choose>
				<c:when test="${fn:length(goodsRead) > 0}">
					<c:forEach items="${goodsRead }" var="goodsRead" varStatus="rowcnt">
						<tr>
							<td colspan="2">${goodsRead.goodsIdx}</td>
							<td colspan="10"><a href="/myspring/Goods/goodsDetail?goodsIdx=${goodsRead.goodsIdx}">${goodsRead.goodsTitle}</a></td>
							<td colspan="5">${goodsRead.writer}</td>
							<td colspan="5">${goodsRead.writeDate}</td>
							<td colspan="2">${goodsRead.goodsViewCnt}</td>
							<td colspan="2">${goodsRead.goodsReplyCnt}</td>
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
		
		 -->

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
			<a href="/myspring/Goods/goodsCreateView">^상품 등록하기^</a>
		</div>
		
	</div>
	<!-- ./div center -->
</body>
<script src="../resources/js/pagination.js"></script>
</html>