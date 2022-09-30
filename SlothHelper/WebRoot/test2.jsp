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



	<form action="test666.jsp" method="post">
	<table class="formcontainer"> </table>
	
	<% 
	if(request.getSession().getAttribute("user_name")==null  ){
		response.sendRedirect("login.html");
			
	}
	else{
		SlothHelperDAO DAOObject= new SlothHelperDAOImp();
		Map<String,String>RandomMap=new HashMap();
		Map<String,String>ContainerMap=new HashMap();
		ContainerMap=DAOObject.Quiz3();
		
		Object randomGenerator = ContainerMap.keySet().toArray()[new Random().nextInt(ContainerMap.keySet().toArray().length)];
    	String Key1= randomGenerator.toString();
    	String Value1=ContainerMap.get(randomGenerator);
    	RandomMap.put(Key1, Value1);
    	String word= RandomMap.keySet().toString();
    	String meaning=RandomMap.values().toString();
    	//String meaning="Awesome";
    	//request.getSession().setAttribute("meaning", meaning);
    	//String test1= request.getAttribute("test1").toString();


	%>
		<tr class="container">
		<td>
			<p style="font-size:50px ;">
					<%= word %>
					<%= meaning %>
					
			</p>
		</td>
		
		<td>
			<input type="text" name="UserValue" required ></input>
		</td>
		
		</tr>
		      
      <div class="container" style="background-color: #eee">
			<button type="submit"><strong>Ok</strong></button>
      </div>
      

		
	<%
	}	
	%>
	
	
	
	</form>
</body>
</html>