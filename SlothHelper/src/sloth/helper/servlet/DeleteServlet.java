package sloth.helper.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sloth.helper.DAO.SlothHelperDAO;
import sloth.helper.DAO.SlothHelperDAOImp;
import sloth.show.deck.*;

public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int deck_id= Integer.parseInt(req.getParameter("deck_id"));
		

		
		SlothHelperDAO DAOObject= new SlothHelperDAOImp();
		
		boolean tag=DAOObject.DeleteWord(deck_id);
		
		if(tag==true) {
			req.getRequestDispatcher("ShowDeck.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("test.jsp").forward(req, resp);
		}
		
		
	}
		
}
