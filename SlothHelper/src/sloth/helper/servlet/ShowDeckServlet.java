package sloth.helper.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sloth.helper.DAO.*;
import sloth.show.deck.*;
public class ShowDeckServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		String deck_id=req.getParameter("#");
		String deck_word=req.getParameter("#");
		String deck_meaning=req.getParameter("#");
		
		ShowDeck deckObject=new ShowDeck();
		deck_id=String.valueOf(deck_id);
		deck_word=deckObject.getDeck_word();
		deck_meaning=deckObject.getDeck_meaning();
		
		req.getSession();
		HttpSession ShowSession=req.getSession(true);
		ShowSession.setAttribute("deck_id", deck_id);
		
		
		
	}

}
