<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>

<script type="text/javascript">
	$(function() {
		$('#btn1').on('click', function(){
			var textarea = $('#textarea').val();
			var textarea = textarea.replace(/\n/g," ");
			alert(textarea);
	        var form = {
	        		storyNo:"3434",
	        		title:"123",
	        		storyContent:textarea
	        }
	         $.ajax({
	      /*       url: "requestObject",
	            dataType:"json",
	            type: "POST",
	            data: form,   */
	            
	             /* url : "http://127.0.0.1:5000/parser", */ 
	            url:"requestObject",
	            contentType:'application/json',
	            method:'POST',
	            crossDomain:true,
	            data: JSON.stringify(form), 
	            
	            success: function(data){
	            	
	            },
	            error: function(error){
	                //alert(error);
	                console.error(error);
	                
	            }
	        }); 
	    });
	});
</script>
</head>
<body>
<textarea rows="30" id="textarea" cols="110"></textarea>
    <button id="btn1">simpleAJAX</button>
    <div id="result"></div>
</body>
</html>