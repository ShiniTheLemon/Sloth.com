<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="sloth.helper.DAO.*" %>    
  <%@ page import="sloth.show.deck.*" %> 
  <%@ page import="java.util.*" %> 
  
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

<form action="">
<table class="formcontainer">
	<%
	if(request.getSession().getAttribute("user_name")==null){
		response.sendRedirect("login.html");
	}else{
		SlothHelperDAO DAOObject= new SlothHelperDAOImp();
		List<ShowDeck> ShowDeckList=DAOObject.ShowDeck();
		
		
		//String test12=ShowDeckList.toString();
		//request.setAttribute("test1", test12);
	%>
			
		<tr class="container">
			<th>Number</th>
			<th>Word</th>
			<th>Meaning</th>
			
		<tr>
	<%
	for(ShowDeck DeckObj : ShowDeckList){
	%>

		<tr class="container">
			<td><% out.print(DeckObj.getDeck_id()); %></td>
			<td><% out.print(DeckObj.getDeck_word()); %></td>
			<td><% out.print(DeckObj.getDeck_meaning()); %></td>
			<td><a href="Delete.jsp">Delete</a></td>
		</tr>
	
<% }		
	}
	%>

	 	
</table>
					<a href="index.jsp">
						<button type="button" class="formcontainer">Main Page</button>
					</a>
</form>
</body>
</html>