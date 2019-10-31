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
	 <header>게시글 수정하기</header>
	 	<form action="/myspring/Board/boardUpdate?boardIdx=${boardUpdate.boardIdx}" method="POST">
			<table>
				<tr>
					<th>게시글 번호</th>
					<td><input type="text" id="boardIdx" name="boardIdx" value="${boardUpdate.boardIdx}" placeholder="boardIdx" disabled/></td>
				</tr>
				<tr>
					<th>게시글 제목</th>
					<td><input type="text" id="boardTitle" name="boardTitle" value="${boardUpdate.boardTitle}" placeholder="boardTitle" /></td>
				</tr>
				<tr>
					<th>게시글 내용</th>
					<td><input type="text" id="boardContent" name="boardContent" value="${boardUpdate.boardContent}" placeholder="boardContent" /></td>
				</tr>
				<tr>
					<th>게시글 작성자</th>
					<td><input type="text" id="writer" name="writer" value="${boardUpdate.writer}" placeholder="writer" /></td>
				</tr>
			</table>
			<div>
				<input type="submit" name="submit" value="수정" />
				<input type="reset" name="reset" value="재 작성" />
			</div>
		</form>
			<div>
				<a href="/myspring/Board/boardRead">게시글 리스트 가기</a>
			</div>
	</div>
</body>
</html>