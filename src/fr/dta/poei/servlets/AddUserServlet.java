package fr.dta.poei.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dta.poei.controllers.UserController;
import fr.dta.poei.entities.User;

/**
 * Servlet implementation class AddUserServlet
 */
//@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StringBuffer path = request.getRequestURL();
		String pathS = path.substring(0, path.lastIndexOf("/"));
		if (request.getParameter("submit") != null) {
			User user = new User();
			user.setFirstName(request.getParameter("firstname"));
			user.setLastName(request.getParameter("lastname"));
			user.setUserName(request.getParameter("username"));
			user.setAdresse(request.getParameter("adresse"));
			user.setPasseword(request.getParameter("passeword"));
			user.setPhone(request.getParameter("phone"));
			user.setEmail(request.getParameter("email"));

			User newUser = UserController.createUser(user, pathS);
			if (newUser != null) {
				request.getSession().setAttribute("user", newUser);
			}
			RequestDispatcher rd = request.getServletContext().getNamedDispatcher("userProfil");
			rd.forward(request, response);

		}
	}

}
