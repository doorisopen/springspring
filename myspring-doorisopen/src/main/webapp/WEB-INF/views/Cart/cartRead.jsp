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
	 <header><h1>장바구니 리스트</h1></header>
 		<a href="/myspring">^홈으로^</a>||
 		<a href="/myspring/Goods/goodsRead">상품 리스트 가기</a>
	 	<!-- Goods List -->
		 <section>
			<article>
				<c:choose>
					<c:when test="${fn:length(cartRead) > 0}">
						<c:forEach items="${cartRead }" var="cartRead" varStatus="rowcnt">
							<div class="img">
							<div class="desc">장바구니 번호: ${cartRead.cartIdx}</div>
								<div class="desc">상품 번호: ${cartRead.goodsIdx}</div>
								<div class="desc">등록자: ${cartRead.writer}</div>
								<div class="desc">상품 수량: ${cartRead.goodsAmount}</div>
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
		<!-- pagination{e}  -->
		
	</div>
	<!-- ./div center -->
</body>
<script src="../resources/js/pagination.js"></script>
</html>