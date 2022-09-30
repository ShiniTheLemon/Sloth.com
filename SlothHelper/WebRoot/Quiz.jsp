  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="sloth.helper.DAO.*" %>    
  <%@ page import="java.util.*" %> 
  <%@ page import="sloth.helper.servlet.*" %>
  
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
<!-- 



 -->



	<form action="RandomServlet" method="post">
	<table class="formcontainer"> </table>
	
	<% 
	if(request.getSession().getAttribute("user_name")==null  ){
		response.sendRedirect("login.html");
			
	}
	else{
		SlothHelperDAO DAOObject= new SlothHelperDAOImp();
		Map<String,String>ContainerMap= new HashMap();
		ContainerMap=DAOObject.Quiz4();
		
		List<String> ValueList = new ArrayList<>(ContainerMap.values());
		request.getSession().setAttribute("ValueList", ValueList);
		
		for(String keys: ContainerMap.keySet()){
		
	

	%>
		<tr class="container">
		<td>
			<p style="font-size:50px ;">
			 
				<%= keys %>
			 
			</p>
		</td>
		
		<td>
			<input type="text" name="UserValue" required ></input>
		</td>
		
		</tr>
		      
  
		
	
	<%
		}
		%>
				    <div class="container" style="background-color: #eee">
				<button type="submit"><strong>Ok</strong></button>
	      </div>
		
		<% 
	} %>
	
	</form>
</body>
</html>