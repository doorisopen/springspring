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
	 <header>게시글 상세보기</header>
			<table>
				<tr>
					<th>게시글 제목</th>
					<td><input type="text" id="boardTitle" name="boardTitle" value="${boardDetail.boardTitle}" placeholder="boardTitle" disabled /></td>
				</tr>
				<tr>
					<th>게시글 내용</th>
					<td><input type="text" id="boardContent" name="boardContent" value="${boardDetail.boardContent}" placeholder="boardContent" disabled /></td>
				</tr>
				<tr>
					<th>게시글 작성자</th>
					<td><input type="text" id="writer" name="writer" value="${boardDetail.writer}" placeholder="writer" disabled /></td>
					
				</tr>
			</table>
			<div>
				<a href="/myspring/Board/boardUpdateView?boardIdx=${boardDetail.boardIdx}">수정하기</a>
			</div>
			<div>
				<a href="/myspring/Board/boardRead">게시글 리스트 가기</a>
			</div>
			<div>
				<a href="/myspring/Board/boardDelete?boardIdx=${boardDetail.boardIdx}">게시글 삭제</a>
			</div>
	</div>
</body>
</html>