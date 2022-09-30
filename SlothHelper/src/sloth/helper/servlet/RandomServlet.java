package sloth.helper.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sloth.helper.DAO.SlothHelperDAO;
import sloth.helper.DAO.SlothHelperDAOImp;

public class RandomServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String UserValue=req.getParameter("UserValue");
		String Value=req.getSession().getAttribute("ValueList").toString();
		


		
		
		
		if(Value.equals(UserValue)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Correct.jsp");
			dispatcher.forward(req, resp);
			
			
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Wrong.jsp");
			dispatcher.forward(req, resp);
			System.out.println(Value);
			System.out.println(UserValue);
		}
	}
	
}
