<!DOCTYPE html>
<html>
  <title>Create Card</title>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <link href="CreateDeck.css" rel="stylesheet">
  </head>
  <body>
  <%
  	if(request.getSession().getAttribute("user_name")==null){
		response.sendRedirect("login.html");
	}
	%>
  
    <form action="CreateDeckServlet" method="post">
      <h1>Create Card</h1>
      <div class="icon">
        <img src="images/logo.jpg" >
      </div>
      <div class="formcontainer">
      <div class="container">
        <label for="uname"><strong>Create new word</strong></label>
        <input type="text" placeholder="Enter new word" name="deck_word" required>
        <label for="mail"><strong>Word Explanation(meaning)</strong></label>
        <input type="text" placeholder="Enter word meaning" name="deck_meaning" required>
        

      </div>
      <button type="submit"><strong>Add To Deck</strong></button>
      <div class="container" style="background-color: #eee">

      </div>
    </form>
  </body>
</html>
