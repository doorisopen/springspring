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
			<div id="replyList"></div>
		</div>

		<!-- Reply List {e}-->

	</div>
</body>

<script>
$(document).ready(function(){
	showReplyList();
});

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
			 htmls += '<div>';
			 htmls += '<div style="display:inline-flex;" id="replyIdx' + this.replyIdx + '">';
			 htmls += '<div class="replyItem">' + this.replyIdx + '</div>';
			 htmls += '<div class="replyItem"><strong>' + this.replyWriter + '</strong></div>';
			 htmls += '<div class="replyItem">' + this.replyContent + '</div>';
			 htmls += '<div class="replyItem"><a href="javascript:void(0)" onclick="fn_editReply(' + this.replyIdx + ', \'' + this.replyWriter + '\', \'' + this.replyContent + '\' )" style="padding-right:5px">수정</a>';
			 htmls += '<a href="javascript:void(0)" onclick="fn_deleteReply(' + this.replyIdx + ')" >삭제</a></div>';
			 htmls += '</div>';
			 htmls += '</div>';
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


function fn_updateReply(replyIdx, replyWriter){
	var url = "/myspring/restBoard/replyUpdate";
	var replyEditContent = $('#editContent').val();
	var paramData = JSON.stringify({"replyContent": replyEditContent
			, "replyIdx": replyIdx
	});

	var headers = {"Content-Type" : "application/json"
			, "X-HTTP-Method-Override" : "POST"};
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


function fn_editReply(replyIdx, replyWriter, replyContent){
	var htmls = "";
	htmls += '<div class="media text-muted pt-3" id="replyIdx' + replyIdx + '">';
	htmls += '<strong class="text-gray-dark">' + replyWriter + '</strong>';
	htmls += '<textarea name="editContent" id="editContent" class="form-control" rows="3">';
	htmls += replyContent;
	htmls += '</textarea>';
	htmls += '<a href="javascript:void(0)" onclick="fn_updateReply(' + replyIdx + ', \'' + replyWriter + '\')" style="padding-right:5px">저장</a>';
	htmls += '<a href="javascript:void(0)" onClick="showReplyList()">취소<a>';	
	htmls += '</div>';

	$('#replyIdx' + replyIdx).replaceWith(htmls);
	$('#replyIdx' + replyIdx + ' #editContent').focus();
}

function fn_deleteReply(replyIdx){
	var url = "/myspring/restBoard/replyDelete";
	var paramData = {"replyIdx": replyIdx};
	$.ajax({
		url: url
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			showReplyList();
		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
}

</script>

</html>