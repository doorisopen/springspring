<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./resources/css/home.css">
</head>
<body>

<!-- 
<video width="80%" src="resources/demovideo.MP4" loop></video>
<div>Let's Go Board</div>
-->
<div class="home-container">
	<div class="banner">
		<h1>
			Hello Spring Framework world!  
		</h1>
	
		<P> ${serverTime}. </P>
	</div>
	<div class="example-container">
		<div class="example">
			<a href="/myspring/Board/boardRead"><button>게시판</button></a>
		</div>
		<div class="example">
			<a href="/myspring/Goods/goodsRead"><button>상품 및 장바구니</button></a>
		</div>
		<div class="example">
			<a href="#"><button>사용자(미구현)</button></a>
		</div>
		<div class="example">
			<a href="/myspring/chat"><button>채팅</button></a>
		</div>
	</div>
</div>

</body>
</html>
