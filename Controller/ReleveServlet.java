package Controller;

import java.io.IOException;
import java.util.ArrayList;

import Model.Etudiant;
import Model.Note;
import Model.ReleveDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/notes")

public class ReleveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String pw = request.getParameter("pwd");

		Etudiant etud = ReleveDB.seConnecter(login, pw);

		if (etud != null) {

			String cin = etud.getCin();
			ArrayList<Note> notes = ReleveDB.getNotes(cin);

			request.getSession().setAttribute("etud", etud);

			request.setAttribute("notes", notes);

			request.getRequestDispatcher("releve.jsp").forward(request, response);

		} else {
			request.setAttribute("erreur", 0);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}

	}

}
