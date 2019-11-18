<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/board.css">
<title>DOOP</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
	<div align=center>
	 <header>상품 상세보기</header>
			<table>
				<tr>
					<th>상품 번호</th>
					<td><input type="text" id="goodsIdx" name="goodsIdx" value="${goodsDetail.goodsIdx}" placeholder="goodsIdx" disabled /></td>
				</tr>
				<tr>
					<th>상품 제목</th>
					<td><input type="text" id="goodsTitle" name="goodsTitle" value="${goodsDetail.goodsTitle}" placeholder="goodsTitle" disabled /></td>
				</tr>
				<tr>
					<th>상품 내용</th>
					<td><input type="text" id="goodsContent" name="goodsContent" value="${goodsDetail.goodsContent}" placeholder="goodsContent" disabled /></td>
				</tr>
				<tr>
					<th>상품 작성자</th>
					<td><input type="text" id="writer" name="writer" value="${goodsDetail.writer}" placeholder="writer" disabled /></td>
				</tr>
				
				<tr>
					<th>상품 수량</th>
					
					<td>
						<form action="/myspring/Cart/cartAdd" method="post">
							<input type="hidden" name="goodsIdx" value="${goodsDetail.goodsIdx}"/>
							<input type="hidden" name="writer" value="${goodsDetail.writer}"/>
							<select name="goodsAmount">
								<c:forEach begin="1" end="10" var="i">
									<option value="${i }">${i }</option>
								</c:forEach>
							</select>&nbsp;개
							<input type="submit" value="장바구니 담기"/>
						</form>
					</td>
					
				</tr>
				
				<c:choose>
					<c:when test="${fn:length(goodsDetail.goodsFilePath) > 0}">
						<tr>
							<th>이미지 파일</th>
							<td><img src="${pageContext.request.contextPath }${goodsDetail.goodsFilePath}" style="width:150px"></td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<th>파일</th>
							<td>등록된 파일이 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
					
				
			</table>	
			<div style="background-color: darkseagreen; width: 300px;">	
				<div>
					<a href="/myspring/Goods/goodsRead">상품 리스트 가기</a>
				</div>
				<div>
					<a href="/myspring/Goods/goodsUpdateView?goodsIdx=${goodsDetail.goodsIdx}">수정하기</a>
				</div>
				<div>
					<a href="/myspring/Goods/goodsDelete?goodsIdx=${goodsDetail.goodsIdx}">상품 삭제</a>
				</div>
			</div>

			<a href="javascript:void(0)" onclick="fn_reviewToReviewRead(${goodsDetail.goodsIdx})" >TEST</a>
			
			
		<!-- Reply Form {s} -->
		<div style="padding-top: 10px">
			<form:form name="form" id="form" role="form" modelAttribute="reviewVO" method="post">
				<form:hidden path="goodsIdx" id="goodsIdx" />
				<div>
					<div>
						<form:textarea path="reviewContent" id="reviewContent" rows="3" placeholder="리뷰를 입력해 주세요"></form:textarea>
						<form:input path="reviewWriter" id="reviewWriter" placeholder="리뷰 작성자"></form:input>
						<button type="button" id="btnReviewCreate" style="margin-top: 10px">저 장</button>
					</div>
				</div>
			</form:form>
		</div>
		
		<!-- /.Reply Form {e} -->



		<!-- Reply List {s}
		<div class="my-3 p-3 bg-white rounded shadow-sm" style="padding-top: 10px">
			<h6 class="border-bottom pb-2 mb-0">Review list</h6>
			<c:set var="goodsIdx" value='${goodsDetail.goodsIdx}'/>
			<div style="display:inline-flex;">
				<table id="reviewList" class="review" border="1"></table>
			</div>
		</div>
		-->
		<!-- /.Reply List {e}-->

	</div>
</body>
<!-- 
<script src="../resources/js/review.js"></script>
 -->
</html>