/**
 * Review JS
 * made by doorisopen
 */

$(document).ready(function(){
	showReviewList();
});
var goodsIdx = document.getElementById('goodsIdx').value;;
let toggle = false;
// 댓글 리스트
function showReviewList(){
	
	var url = "/myspring/Review/reviewRead";
	var paramData = {"goodsIdx" : goodsIdx};
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
			 htmls += '<tr id=reviewIdx'+ this.reviewIdx +'>';
			 htmls += '<td>' + this.reviewIdx + '</td>';
			 htmls += '<td><strong>' + this.reviewWriter + '</strong></td>';
			 htmls += '<td width="200px">' + this.reviewContent + '</td>';
			 htmls += '<td><a href="javascript:void(0)" onclick="fn_formReviewToReview(' + this.reviewIdx + ')" style="padding-right:5px">답글</a></td>';
			 htmls += '<td><a href="javascript:void(0)" onclick="fn_editReply(' + this.reviewIdx + ', \'' + this.reviewWriter + '\', \'' + this.reviewContent + '\' )" style="padding-right:5px">수정</a></td>';
			 htmls += '<td><a href="javascript:void(0)" onclick="fn_deleteReply(' + this.reviewIdx + ', ' + this.goodsIdx + ')" >삭제</a></td>';
			 htmls += '</tr>';
			 htmls += '<tr><td colspan="6" id="replyIdx' + this.replyIdx + '_reply"></td></tr>';
			});	//each end

		}
		$("#reviewList").html(htmls);
		}// Ajax success end
		,  error:function(request,status,error){
        	alert("goodsIdx: "+goodsIdx+"code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
     	}

	});// Ajax end
}
// /.댓글 리스트
// 댓글 저장
$(document).on('click', '#btnReviewCreate', function(){
	var url = "/myspring/Review/reviewCreate";
	var reviewContent = $('#reviewContent').val();
	var reviewWriter = $('#reviewWriter').val();
	var paramData = JSON.stringify({"reviewContent": reviewContent
			, "reviewWriter": reviewWriter
			, "goodsIdx": goodsIdx
	});
	
	var headers = {"Content-Type" : "application/json", "X-HTTP-Method-Override" : "POST"};
	$.ajax({
		url: url
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			showReviewList();	
			$('#reviewContent').val('');
			$('#reviewWriter').val('');
		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
});
// /.댓글 저장
// 댓글 수정 폼
function fn_editReply(reviewIdx, reviewWriter, reviewContent){
	
	var htmls = "";
	htmls += '<tr id="reviewIdx' + reviewIdx + '">';
	htmls += '<td>' + reviewIdx + '</td>';
	htmls += '<td><strong>' + reviewWriter + '</strong></td>';
	htmls += '<td><textarea name="editContent" id="editContent" rows="2" cols="10">';
	htmls += reviewContent;
	htmls += '</textarea></td>';
	htmls += '<td><a href="javascript:void(0)" onclick="fn_updateReply(' + reviewIdx + ', \'' + reviewWriter + '\')" style="padding-right:5px">저장</a></td>';
	htmls += '<td><a href="javascript:void(0)" onClick="showReviewList()">취소<a></td>';	
	htmls += '</tr>';
	
	$('#reviewIdx' + reviewIdx).replaceWith(htmls);
	$('#reviewIdx' + reviewIdx + ' #editContent').focus();
	
}
// /.댓글 수정 폼
// 댓글 수정
function fn_updateReply(replyIdx, replyWriter){
	var url = "/myspring/Reply/replyUpdate";
	var reviewEditContent = $('#editContent').val();
	var paramData = JSON.stringify({"replyContent": reviewEditContent
			, "reviewIdx": reviewIdx
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
			showReviewList();
		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
}
// /.댓글 수정
// 댓글 삭제
function fn_deleteReply(reviewIdx, goodsIdx){
	var url = "/myspring/Review/reviewDelete";
	var paramData = JSON.stringify({"reviewIdx": reviewIdx
		, "goodsIdx": goodsIdx
	});
	var headers = {"Content-Type" : "application/json", "X-HTTP-Method-Override" : "POST"};
	$.ajax({
		url: url
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			showReviewList();
		}
		,  error:function(request,status,error){
	    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	 	}
	});
}
// /.댓글 삭제
// 대 댓글 폼
function fn_formReviewToReview(reviewIdx){
	if(toggle === false){
		toggle = true;
		var htmls = "";
		htmls += '<div>';
		htmls += '<textarea name="reviewToReviewContent" id="reviewToReviewContent" rows="3"></textarea>';
		htmls += '<input type="text" name="reviewToReviewWriter" id="reviewToReviewWriter" />';
		htmls += '<a href="javascript:void(0)" onclick="fn_reviewToReviewCreate(' + reviewIdx + ')" style="padding-right:5px">저장</a>';
		htmls += '<a href="javascript:void(0)" onClick="showReviewList()">취소<a>';	
		htmls += '</div>';
		$('#reviewIdx' + reviewIdx + '_review').html(htmls);
		$('#reviewToReviewContent').focus();
	} else {
		toggle = false;
		var htmls = "";
	}
	$('#reviewIdx' + replyIdx + '_review').html(htmls);
}
// /.대 댓글 폼
// 대댓글 작성
function fn_reviewToReviewCreate(reviewIdx){
	var url = "/myspring/Review/reviewToReviewCreate";
	var reviewToReviewContent = $('#reviewToReviewContent').val();
	var reviewToReviewWriter = $('#reviewToReviewWriter').val();
	var paramData = JSON.stringify({
			"reviewToReviewContent": reviewToReviewContent
			, "reviewToReviewWriter": reviewToReviewWriter
			, "reviewIdx": reviewIdx
			, "goodsIdx": goodsIdx
	});
	
	var headers = {"Content-Type" : "application/json", "X-HTTP-Method-Override" : "POST"};
	$.ajax({
		url: url
		, headers : headers
		, data : paramData
		, type : 'POST'
		, dataType : 'text'
		, success: function(result){
			showReviewList();	
			$('#reviewToReviewContent').val('');
			$('#reviewToReviewWriter').val('');
		}
		, error: function(error){
			console.log("에러 : " + error);
		}
	});
}
// /.대댓글 작성


// 대댓글 리스트 TEST~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
function fn_reviewToReviewRead(goodsIdx){
	var url = "/myspring/Review/reviewToReviewRead";
	var paramData = {"goodsIdx" : goodsIdx};
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