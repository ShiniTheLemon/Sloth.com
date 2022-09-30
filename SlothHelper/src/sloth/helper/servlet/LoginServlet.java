package sloth.helper.servlet;

import java.io.IOException;
import sloth.helper.DAO.*;
import sloth.helper.login.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String user_name=request.getParameter("user_name");
		String user_password=request.getParameter("user_password");
		
		request.getSession();
		
		RequestDispatcher dispatcher=null;
		
		SlothHelperDAO DAOobj=new SlothHelperDAOImp();
		
		SlothLogin LoginObj=DAOobj.SlothLogin(user_name, user_password);
		
		if(LoginObj!=null) {
			HttpSession newSession= request.getSession(true);
			newSession.setAttribute("user_name", user_name);
			
		    dispatcher= request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
			//response.sendRedirect("test.jsp");
			
		}else {
			dispatcher=request.getRequestDispatcher("login.html");
			dispatcher.forward(request, response);

			//response.sendRedirect("login.html");
		}
		
	}

}
