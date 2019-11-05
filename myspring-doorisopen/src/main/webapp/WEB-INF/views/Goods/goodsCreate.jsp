<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOOP</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
	<div align=center>
	 <header>상품 등록하기</header>
		<form action="/myspring/Goods/goodsCreate" method="POST" enctype="multipart/form-data">
			<table>
				<tr>
					<th>상품 제목</th>
					<td><input type="text" name="goodsTitle" id="goodsTitle" autofocus placeholder="공백없이 입력하세요"/></td>
				</tr>
				<tr>
					<th>상품 내용</th>
					<td><input type="text" name="goodsContent" id="goodsContent" placeholder="공백없이 입력하세요"/></td>
				</tr>
				<tr>
					<th>상품 작성자</th>
					<td><input type="text" name="writer" id="writer" placeholder="공백없이 입력하세요"/></td>
				</tr>
				<tr>
					<th>상품 이미지 파일</th>
					<td>
						<input type="file" name="file" id="file"/>
						<div class="select_img">
							<img src=""/>
						</div>
					</td>
				</tr>
			</table>
			<%=request.getRealPath("/") %>
			<div>
				<input type="submit" name="submit" value="등록" />
				<input type="reset" name="reset" value="재 작성" />
			</div>
			<div>
				<a href="/myspring/Goods/goodsRead">상품 리스트 가기</a>
			</div>
		</form>	
	</div>
</body>

<script src="../resources/js/img_Preview.js"></script>
</html>