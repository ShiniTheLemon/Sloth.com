package sloth.helper.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Random;
import java.util.Set;

import sloth.helper.DAO.*;
import sloth.helper.randomizer.*;

public class RandomizerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//this value will be checked if it is corrrect or not
		// accroding to the map
		String UserValue=req.getParameter("UserValue");
		
		//initialize a map to store information from database
		//Map<String,String>ServletMap=null;
		//initialize another map to store the random value and key obtained
		//Map<String,String>RandomMap=null;
		
		
		//creating a DAO object to get the map of values from db
		//SlothHelperDAO DAOObject= new SlothHelperDAOImp();
		//ServletMap= DAOObject.Quiz3();
		//create random object to select random key from map
		//Object randomGenerator = ServletMap.keySet().toArray()[new Random().nextInt(ServletMap.keySet().toArray().length)];
    	
	
			//get random key and value assign to new map
	    	//String Key1= randomGenerator.toString();
	    	//String Value1=ServletMap.get(randomGenerator);
	    	//RandomMap.put(Key1, Value1);
			
	    	
	    	//a collection of values and keys
	    	//Collection<String> Values=RandomMap.values();
	    	//Set<String> Keys=RandomMap.keySet();
	    	//create session to store the key
			//req.getSession();
			//HttpSession randomSession= req.getSession(true);
			//randomSession.setAttribute("Keys", Keys);
	    	
	    	//String Key2=Keys.toString();
	    	//req.setAttribute("Key2", Key2);
	    	
	    	
	    	
	    	//String meaning= req.getAttribute("meaning").toString();
			//  String test="it works properly";
			  //req.setAttribute("test", test);
	    	if(UserValue==req.getSession().getAttribute("meaning").toString()) {
	    		RequestDispatcher dispatcher = req.getRequestDispatcher("Correct.jsp");
	    		dispatcher.forward(req, resp);
	    	}else {
	    		RequestDispatcher dispatcher = req.getRequestDispatcher("Wrong.jsp");
	    		dispatcher.forward(req, resp);
	    	}
		


	}

}
