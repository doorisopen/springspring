/**
 * Img Preview by doop
 */




$('#file').change(function(){
   if(this.files && this.files[0]) {
    var reader = new FileReader;
    reader.onload = function(data) {
     $('.select_img img').attr('src', data.target.result).width(150);        
    }
    reader.readAsDataURL(this.files[0]);
   }
});

// 게시글 이미지 삭제
function fn_deleteBoardImg(){
	var url = "/myspring/Board/deleteImg";
	var boardIdx = $('#boardIdx').val();
	var boardTitle = $('#boardTitle').val();
	var boardContent = $('#boardContent').val();
	var writer = $('#writer').val();
	var paramData = JSON.stringify({"boardIdx": boardIdx,
		"boardTitle": boardTitle,
		"boardContent": boardContent,
		"writer": writer
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
			location.reload();
		}
		,  error:function(request,status,error){
	    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	 	}
	});
}

// 상품 이미지 삭제
function fn_deleteGoodsImg(){
	var url = "/myspring/Goods/deleteImg";
	var goodsIdx = $('#goodsIdx').val();
	var goodsTitle = $('#goodsTitle').val();
	var goodsContent = $('#goodsContent').val();
	var writer = $('#writer').val();
	var paramData = JSON.stringify({"boardIdx": boardIdx,
		"goodsTitle": goodsTitle,
		"goodsContent": goodsContent,
		"writer": writer
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
			location.reload();
		}
		,  error:function(request,status,error){
	    	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	 	}
	});
}