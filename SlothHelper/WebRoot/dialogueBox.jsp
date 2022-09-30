<<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <<link rel="stylesheet" href="CreateDeck.css">
  </head>
  <body>
  
  <% 
			if(request.getSession().getAttribute("user_name")==null){
		response.sendRedirect("login.html");
	     }
   %>
    <form action="">
    
    	      <h1>Do you want to continue adding new words to the deck?</h1>
		
		<table>
		<tr>
					<a href="CreateDeck.jsp">
			        	<button type="button" name="button"> Yes </button>
			        </a>
		</tr>
		
		<tr>				<a href="index.jsp">
						        	<button type="button" name="button">No </button>
						     </a>
		</tr>
		
		</table>


    
    </form>


  </body>
</html>
