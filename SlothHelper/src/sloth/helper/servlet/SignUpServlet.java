package sloth.helper.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sloth.helper.DAO.*;
import sloth.helper.user.signup.*;

public class SignUpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		//Collects all the user entered on the signup page
		String email=request.getParameter("email");
		String user_name=request.getParameter("user_name");
		String user_password=request.getParameter("user_password");
		
		//creates a usersignup object and assigns in the values the user entered
		SlothSignUp SlothSignUpObj= new SlothSignUp();
		SlothSignUpObj.setEmail(email);
		SlothSignUpObj.setUser_name(user_name);
		SlothSignUpObj.setUser_password(user_password);
		
		//a userDAO object is called to communicate to the database
		SlothHelperDAO DAOobject= new SlothHelperDAOImp();
		
		
		// check the method add user in DAO whose return type is boolean
		// the parameter is user sign up object the below statement checks 
		// if  the tag is true meaning the information has been entered
		//else the information has not been entered and the user is redirected to the sign up page
		
		if(DAOobject.SlothSignUp(SlothSignUpObj)) {
			response.sendRedirect("login.html");
		}else
			response.sendRedirect("signUp.html");
	
		
	}
}
