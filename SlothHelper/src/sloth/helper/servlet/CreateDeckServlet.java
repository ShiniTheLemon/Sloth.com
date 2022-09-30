package sloth.helper.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sloth.helper.DAO.*;
import sloth.create.deck.*;

public class CreateDeckServlet extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("UTF-8");
		String deck_word=req.getParameter("deck_word");
		String deck_meaning=req.getParameter("deck_meaning");
		
		CreateDeck deckObject= new CreateDeck();
		deckObject.setDeck_word(deck_word);
		deckObject.setDeck_meaning(deck_meaning);
		
		
		SlothHelperDAO DAOObject=new SlothHelperDAOImp();
		
		boolean tag=DAOObject.SlothCreateDeck(deckObject);
		if(tag=true) {
			resp.sendRedirect("dialogueBox.jsp");
		}else
		{
			resp.sendRedirect("CreateDeck.jsp");
		}
		
		
	}

}
