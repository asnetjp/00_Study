$(function() {

	  $("#test").on("click", function() {

	    var model = {
	      "no" : "1",
	      "name" : "1"
	    };

	    console.log(model);
	    //JSON.stringfy : JSのオブジェクトや値をJSON文字列に変換する
	    console.log(JSON.stringify(model));

	    $.ajax({
	      url : '/demo1/',
	      type : 'POST',
	      data : JSON.stringify(model),
	      contentType : 'application/json', //Jsonでやり取りしますよ、送りますよ
	      error : function() {
	        console.log("error");
	      },
	      success : function(sysinId) {
	        console.log("success");
	      }
	    });

	  });

	});