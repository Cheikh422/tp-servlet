package fr.dta.poei.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dta.poei.controllers.UserController;
import fr.dta.poei.entities.User;
import fr.dta.poei.services.UserService;

/**
 * Servlet implementation class EditUserServlet
 */
//@WebServlet("/editUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		Map<Integer, User> users = (HashMap<Integer, User>) request.getServletContext().getAttribute("users");
//		User user = users.get(Integer.parseInt(request.getParameter("idToEdit")));
//		request.getSession().setAttribute("user", user);
//		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("editUser");
//		rd.forward(request, response);
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService controller = new UserService(request.getServletContext());
		HttpSession session = request.getSession();
		StringBuffer path = request.getRequestURL();
		String pathS = path.substring(0, path.lastIndexOf("/"));
		session.getServletContext();
		if (request.getParameter("edit") != null) {
			User user = (User) request.getSession().getAttribute("user");
			request.getSession().setAttribute("user", user);

			RequestDispatcher rd = request.getServletContext().getNamedDispatcher("formUser");
			rd.forward(request, response);

		}
		if (request.getParameter("delete") != null) {
			User user = UserController.deleteUserById(Integer.parseInt(request.getParameter("delete")), pathS);
			controller.delete(user.getId());
			RequestDispatcher rd = request.getServletContext().getNamedDispatcher("userJsp");
			rd.forward(request, response);
		}
		if (request.getParameter("edit") != null) {
			User user = (User) request.getSession().getAttribute("user");
			String firstName = (String) request.getParameter("firstname");
			user.setFirstName(firstName);
			user.setLastName(request.getParameter("lastname"));
			user.setUserName(request.getParameter("username"));
			user.setAdresse(request.getParameter("adresse"));
			user.setPasseword(request.getParameter("passeword"));
			user.setPhone(request.getParameter("phone"));
			user.setEmail(request.getParameter("email"));
			UserController.updateUser(user, pathS);
			RequestDispatcher rd = request.getServletContext().getNamedDispatcher("IndexServlet");
			rd.forward(request, response);

		}
		if (request.getParameter("index") != null) {
			RequestDispatcher rd = request.getServletContext().getNamedDispatcher("IndexServlet");
			rd.forward(request, response);
		}

	}

}
