/**
 * Reply JS
 * made by doorisopen
 */

$(document).ready(function(){
	ReplyToggle();
	//showReplyList();
});
var boardIdx = document.getElementById('boardIdx').value;;
let toggle = false;
// 댓글 리스트

function ReplyToggle() {
	
	if(toggle === false) {
		var htmls = "";
		toggle = true;
	} else {
		showReplyList();
		toggle = false;
	}
	$("#replyList").html(htmls);
}
function showReplyList(){
	
	var url = "/myspring/Reply/replyRead";
	var paramData = {"boardIdx" : boardIdx};
	$.ajax({
           type: 'POST',
           url: url,
           data: paramData,
           dataType: 'json',
           success: function(result) {
              	var htmls = "";
             	htmls += '<tr>';
   			 	htmls += '<th>idx</th>';
   			 	htmls += '<th>작성자</th>';
   			 	htmls += '<th>내용</th>';
   			 	htmls += '</tr>'
		if(result.length < 1){
		htmls += '등록된 댓글이 없습니다.';
		} else {
			$(result).each(function(){
			 htmls += '<tr id=replyIdx'+ this.replyIdx +'>';
			 htmls += '<td>' + this.replyIdx + '</td>';
			 htmls += '<td><strong>' + this.replyWriter + '</strong></td>';
			 htmls += '<td width="200px">' + this.replyContent + '</td>';
			 htmls += '<td><a href="javascript:void(0)" onclick="fn_formReplyToReply(' + this.replyIdx + ')" style="padding-right:5px">답글</a></td>';
			 htmls += '<td><a href="javascript:void(0)" onclick="fn_editReply(' + this.replyIdx + ', \'' + this.replyWriter + '\', \'' + this.replyContent + '\' )" style="padding-right:5px">수정</a></td>';
			 htmls += '<td><a href="javascript:void(0)" onclick="fn_deleteReply(' + this.replyIdx + ', ' + this.boardIdx + ')" >삭제</a></td>';
			 htmls += '</tr>';
			 htmls += '<tr><td colspan="6" id="replyIdx' + this.replyIdx + '_reply"></td></tr>';
			});	//each end

		}
		$("#replyList").html(htmls);
		}// Ajax success end
		,  error:function(request,status,error){
        	alert("boardIdx: "+boardIdx+"code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
     	}

	});// Ajax end
}
// /.댓글 리스트
// 댓글 저장
$(document).on('click', '#btnReplyCreate', function(){
	var url = "/myspring/Reply/replyCreate";
	var replyContent = $('#replyContent').val();
	var replyWriter = $('#replyWriter').val();
	var paramData = JSON.stringify({"replyContent": replyContent
			, "replyWriter": replyWriter
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
			$('#replyContent').val('');
			$('#replyWriter').val('');
		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
});
// /.댓글 저장
// 댓글 수정 폼
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
// /.댓글 수정 폼
// 댓글 수정
function fn_updateReply(replyIdx, replyWriter){
	var url = "/myspring/Reply/replyUpdate";
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
// 댓글 삭제
function fn_deleteReply(replyIdx, boardIdx){
	var url = "/myspring/Reply/replyDelete";
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
// 대 댓글 폼
function fn_formReplyToReply(replyIdx){
	if(toggle === false){
		var htmls = "";
		htmls += '<div>';
		htmls += '<textarea name="replyToReplyContent" id="replyToReplyContent" rows="3"></textarea>';
		htmls += '<input type="text" name="replyToReplyWriter" id="replyToReplyWriter" />';
		htmls += '<a href="javascript:void(0)" onclick="fn_replyToReplyCreate(' + replyIdx + ')" style="padding-right:5px">저장</a>';
		htmls += '<a href="javascript:void(0)" onClick="showReplyList()">취소<a>';	
		htmls += '</div>';
		$('#replyIdx' + replyIdx + '_reply').html(htmls);
		$('#replyToReplyContent').focus();
		toggle = true;
	} else {
		var htmls = "";
		toggle = false;
	}
	$('#replyIdx' + replyIdx + '_reply').html(htmls);
}
// /.대 댓글 폼
// 대댓글 작성
function fn_replyToReplyCreate(replyIdx){
	var url = "/myspring/Reply/replyToReplyCreate";
	var replyToReplyContent = $('#replyToReplyContent').val();
	var replyToReplyWriter = $('#replyToReplyWriter').val();
	var paramData = JSON.stringify({
			"replyToReplyContent": replyToReplyContent
			, "replyToReplyWriter": replyToReplyWriter
			, "replyIdx": replyIdx
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
			$('#replyToReplyContent').val('');
			$('#replyToReplyWriter').val('');
		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
}
// /.대댓글 작성


// 대댓글 리스트 TEST~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function fn_replyToReplyRead(boardIdx){
	var url = "/myspring/Reply/replyToReplyRead";
	var paramData = {"boardIdx" : boardIdx};
	$.ajax({
        type: 'POST',
        url: url,
        data: paramData,
        dataType: 'json',
		   success: function(result){
			
		}
		,  error:function(request,status,error){
	    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	 	}
	});
}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~