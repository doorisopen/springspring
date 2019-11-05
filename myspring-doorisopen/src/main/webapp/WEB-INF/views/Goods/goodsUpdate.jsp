<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOOP</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
	<div align=center>
	 <header>게시글 수정하기</header>
	 	<form action="/myspring/Goods/goodsUpdate?goodsIdx=${goodsUpdate.goodsIdx}" method="POST" enctype="multipart/form-data">
			<table>
				<tr>
					<th>게시글 번호</th>
					<td><input type="text" id="goodsIdx" name="goodsIdx" value="${goodsUpdate.goodsIdx}" placeholder="goodsIdx" disabled/></td>
				</tr>
				<tr>
					<th>게시글 제목</th>
					<td><input type="text" id="goodsTitle" name="goodsTitle" value="${goodsUpdate.goodsTitle}" placeholder="goodsTitle" /></td>
				</tr>
				<tr>
					<th>게시글 내용</th>
					<td><input type="text" id="goodsContent" name="goodsContent" value="${goodsUpdate.goodsContent}" placeholder="goodsContent" /></td>
				</tr>
				<tr>
					<th>게시글 작성자</th>
					<td><input type="text" id="writer" name="writer" value="${goodsUpdate.writer}" placeholder="writer" /></td>
				</tr>
				
				<c:choose>
					<c:when test="${fn:length(goodsUpdate.goodsFilePath) > 0}">
						<tr>
							<th>이미지 파일</th>
							<td>
								<input type="file" name="file" id="file"/>
								<input type="hidden" name="goodsFilePath" value="${goodsUpdate.goodsFilePath}"/>
								<div class="select_img">
									<img src=""/>
								</div>
								<img name="goodsFilePath" src="${pageContext.request.contextPath }${goodsUpdate.goodsFilePath}" style="width:150px">
							</td>
							<td><a href="javascript:void(0)" onclick="fn_deleteGoodsImg()" >이미지 삭제</a></td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<th>파일</th>
							<td>
								<input type="file" name="file" id="file"/>
								<div class="select_img">
									<img src=""/>
								</div>
								등록된 파일이 없습니다.
							</td>
						</tr>
					</c:otherwise>
				</c:choose>
				
			</table>
			<%=request.getRealPath("/") %>
			<div>
				<input type="submit" name="submit" value="수정" />
				<input type="reset" name="reset" value="재 작성" />
			</div>
		</form>
			<div>
				<a href="/myspring/Goods/goodsRead">게시글 리스트 가기</a>
			</div>
	</div>
</body>
<script src="../resources/js/img_Preview.js"></script>
</html>