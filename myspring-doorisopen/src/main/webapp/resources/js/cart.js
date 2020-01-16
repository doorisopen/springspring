/**
 * Cart JS
 * made by doorisopen
 */
// 댓글 삭제
function fn_deleteCartGoods(writer, goodsIdx){
	var url = "/myspring/Cart/cartDelete";
	var paramData = JSON.stringify({"writer": writer
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
			alert("상품 삭제 완료");
			location.reload();
		}
		,  error:function(request,status,error){
	    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	 	}
	});
}
// /.댓글 삭제
