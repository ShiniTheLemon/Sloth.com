<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Test 1 2 Test 1 2 3</h1>


<%

	String user_name=null;
	if(request.getSession().getAttribute("user_name")==null){
		response.sendRedirect("login.html");
	}else
	{
		user_name=request.getSession().getAttribute("user_name").toString();
	}


%>

	<h2>Welcome:</h2>
	<%=user_name %>
	
	<form action="LogOutServlet" method="post"><button type="submit">Log Out</button></form>

</body>
</html>