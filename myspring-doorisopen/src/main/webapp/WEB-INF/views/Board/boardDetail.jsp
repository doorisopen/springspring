<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

		<!-- Reply Form {s} -->
		<div style="padding-top: 10px">
			<form:form name="form" id="form" role="form" modelAttribute="replyVO" method="post">
				<form:hidden path="boardIdx" id="boardIdx" />
				<div>
					<div>
						<form:textarea path="replyContent" id="replyContent" rows="3" placeholder="댓글을 입력해 주세요"></form:textarea>
						<form:input path="replyWriter" id="replyWriter" placeholder="댓글 작성자"></form:input>
						<button type="button" id="btnReplyCreate" style="margin-top: 10px">저 장</button>
					</div>
				</div>
			</form:form>
		</div>
		<!-- Reply Form {e} -->



		<!-- Reply List {s}-->

		<div class="my-3 p-3 bg-white rounded shadow-sm"
			style="padding-top: 10px">
			<h6 class="border-bottom pb-2 mb-0">Reply list</h6>
			<!--  <div id="replyList"></div> -->
			<div style="display:inline-flex;">
				<table id="replyList" class="reply" border="1"></table>
			</div>
		</div>

		<!-- Reply List {e}-->

	</div>
</body>

<script>
$(document).ready(function(){
	showReplyList();
});

let toggle = false;

function showReplyList(){
	
	var url = "/myspring/restBoard/replyRead";
	var paramData = {"boardIdx" : "${boardDetail.boardIdx}"};
	$.ajax({
           type: 'POST',
           url: url,
           data: paramData,
           dataType: 'json',
           success: function(result) {
              	var htmls = "";
		if(result.length < 1){
		htmls += '등록된 댓글이 없습니다.';
		} else {
			$(result).each(function(){
			 htmls += '<tr>';
			 htmls += '<th>idx</th>';
			 htmls += '<th>작성자</th>';
			 htmls += '<th>내용</th>';
			 htmls += '</tr><tr id=replyIdx'+ this.replyIdx +'>';
			 htmls += '<td>' + this.replyIdx + '</td>';
			 htmls += '<td><strong>' + this.replyWriter + '</strong></td>';
			 htmls += '<td>' + this.replyContent + '</td>';
			 htmls += '<td><a href="javascript:void(0)" onclick="fn_formReplyToReply(' + this.replyIdx + ')" style="padding-right:5px">답글</a></td>';
			 htmls += '<td><a href="javascript:void(0)" onclick="fn_editReply(' + this.replyIdx + ', \'' + this.replyWriter + '\', \'' + this.replyContent + '\' )" style="padding-right:5px">수정</a></td>';
			 htmls += '<td><a href="javascript:void(0)" onclick="fn_deleteReply(' + this.replyIdx + ', ' + this.boardIdx + ')" >삭제</a></td>';
			 htmls += '</tr>';
			 htmls += '<tr><td colspan="6" id="replyIdx' + this.replyIdx + '_reply"></td></tr>';
			 htmls += '<tr><td>대댓글존</td></tr>';
			});	//each end

		}
		$("#replyList").html(htmls);
		}// Ajax success end
		,  error:function(request,status,error){
        	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
     	}

	});// Ajax end
}

//댓글 저장 버튼 클릭 이벤트
$(document).on('click', '#btnReplyCreate', function(){
	var url = "${pageContext.request.contextPath}/restBoard/replyCreate";
	var replyContent = $('#replyContent').val();
	var replyWriter = $('#replyWriter').val();
	var paramData = JSON.stringify({"replyContent": replyContent
			, "replyWriter": replyWriter
			, "boardIdx":'${boardDetail.boardIdx}'
	});
	
	var headers = {"Content-Type" : "application/json", "X-HTTP-Method-Override" : "POST"};
	$.ajax({
		url: url
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			showReplyList();	
			$('#replyContent').val('');
			$('#replyWriter').val('');
		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
});

// 댓글 수정
function fn_editReply(replyIdx, replyWriter, replyContent){
	
	var htmls = "";
	htmls += '<tr id="replyIdx' + replyIdx + '">';
	htmls += '<td>' + replyIdx + '</td>';
	htmls += '<td><strong>' + replyWriter + '</strong></td>';
	htmls += '<td><textarea name="editContent" id="editContent" rows="2" cols="10">';
	htmls += replyContent;
	htmls += '</textarea></td>';
	htmls += '<td><a href="javascript:void(0)" onclick="fn_updateReply(' + replyIdx + ', \'' + replyWriter + '\')" style="padding-right:5px">저장</a></td>';
	htmls += '<td><a href="javascript:void(0)" onClick="showReplyList()">취소<a></td>';	
	htmls += '</tr>';
	
	$('#replyIdx' + replyIdx).replaceWith(htmls);
	$('#replyIdx' + replyIdx + ' #editContent').focus();
	
}
function fn_updateReply(replyIdx, replyWriter){
	var url = "/myspring/restBoard/replyUpdate";
	var replyEditContent = $('#editContent').val();
	var paramData = JSON.stringify({"replyContent": replyEditContent
			, "replyIdx": replyIdx
	});

	var headers = {"Content-Type" : "application/json", "X-HTTP-Method-Override" : "POST"};
	$.ajax({
		url: url
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
            console.log(result);
			showReplyList();
		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
}
// /.댓글 수정

// 대 댓글 폼
function fn_formReplyToReply(replyIdx){
	if(toggle === false){
		toggle = true;
		var htmls = "";
		htmls += '<div>';
		htmls += '<textarea name="replyToReplyContent" id="replyToReplyContent" rows="3"></textarea>';
		htmls += '<input type="text" name="replyToReplyWriter" id="replyToReplyWriter" />';
		htmls += '<a href="javascript:void(0)" onclick="fn_replyToReplyCreate(' + replyIdx + ')" style="padding-right:5px">저장</a>';
		htmls += '<a href="javascript:void(0)" onClick="showReplyList()">취소<a>';	
		htmls += '</div>';
		$('#replyIdx' + replyIdx + '_reply').html(htmls);
		$('#replyToReplyContent').focus();
	} else {
		toggle = false;
		var htmls = "";
	}
	$('#replyIdx' + replyIdx + '_reply').html(htmls);
}
// 대댓글 작성
function fn_replyToReplyCreate(replyIdx){
	var url = "${pageContext.request.contextPath}/restBoard/replyToReplyCreate";
	var replyToReplyContent = $('#replyToReplyContent').val();
	var replyToReplyWriter = $('#replyToReplyWriter').val();
	var paramData = JSON.stringify({
			"replyToReplyContent": replyToReplyContent
			, "replyToReplyWriter": replyToReplyWriter
			, "replyIdx": replyIdx
	});
	
	var headers = {"Content-Type" : "application/json", "X-HTTP-Method-Override" : "POST"};
	$.ajax({
		url: url
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			showReplyList();	
			$('#replyToReplyContent').val('');
			$('#replyToReplyWriter').val('');
		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
}
// /.대댓글 작성

// 댓글 삭제
function fn_deleteReply(replyIdx, boardIdx){
	var url = "/myspring/restBoard/replyDelete";
	var paramData = JSON.stringify({"replyIdx": replyIdx
		, "boardIdx": boardIdx
	});
	var headers = {"Content-Type" : "application/json", "X-HTTP-Method-Override" : "POST"};
	$.ajax({
		url: url
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			showReplyList();
		}
		,  error:function(request,status,error){
	    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	 	}
	});
}
// /.댓글 삭제
</script>

</html>