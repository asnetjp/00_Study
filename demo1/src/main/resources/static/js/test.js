/**
 * 
 */
	$('#button1').click(function(){
  		$.ajax({
    		url: "/demo1/jq",
    		dataType: "html",
    	})
			.done(function(){
     			 $('#lists').append('<input type="button" value="増えたボタン">');
				 $('h1').html("<h2>変わったよ</h2>")
    		}).fail(function(){
				consol.log("error")
		})
	});
	
	$(function(){
		$('.button').fadeOut(4000)
	});

  $("#1").click(function(){
    $("#1").after("<div id=\"2\">２つ目の要素追加</div>");
  });

  $("#1").click(function(){
    alert("1つ目の要素クリック");
  });

  $(document).on("click", "#2", function(){
	    alert("2つ目の要素クリック");
	});