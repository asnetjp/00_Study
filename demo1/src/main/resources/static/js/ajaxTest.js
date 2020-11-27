/**
 * 
 */
$(function() {

$("#ajax_button").on('click',function(){
	var send_id = {empid : $("#empid").val()};
	
	
	$.ajax({
		type : 'POST',
		url : '/demo1/ajaxTest',
		data : JSON.stringify(send_id),
		contentType : 'application/json',
		success: function(data1) {
			$("#name").text(JSON.stringify(data1));
            alert("送信が完了しました。");
        },
        error: function() {
          alert("予期せぬエラーが発生しました。");
        }
		
	});
});
});