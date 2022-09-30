<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <link href="CreateDeck.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

	  <% 
			if(request.getSession().getAttribute("user_name")==null){
		response.sendRedirect("login.html");
	     }
   %>

	<form action="DeleteServlet" method="post">
		    
    	      <h1>Enter card number to confirm Deletion otherwise press return button to go back!</h1>
		
		<table>
		 <div class="formcontainer">
		<tr>
					<input type="text" name="deck_id" placeholder="Enter card number"  required>
					 <button type="submit"><strong>Delete</strong></button>
		</tr>
		
		<tr>				<a href="index.jsp">
						        	<button type="button" name="button">Return </button>
						     </a>
		</tr>
		</div>
		
		</table>
		
	
	</form>
</body>
</html>