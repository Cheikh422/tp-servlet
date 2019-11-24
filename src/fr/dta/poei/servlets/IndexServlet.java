package fr.dta.poei.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dta.poei.controllers.UserController;
import fr.dta.poei.entities.User;

/**
 * Servlet implementation class IndexServlet
 */
//@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StringBuffer path = request.getRequestURL();
		String pathS = path.substring(0, path.lastIndexOf("/"));
		String forward = "index";
		int page = 1;
		int recordsPerPage = 1200;
		if (request.getParameter("view") != null) {
			User user = UserController.getUserById(Integer.parseInt(request.getParameter("view")), pathS);
			request.getSession().setAttribute("user", user);
			forward = "userProfil";
		}
		if (request.getParameter("add") != null) {
			forward = "addUser";
		}
		if (request.getParameter("delete") != null) {
			UserController.deleteUserById(Integer.parseInt(request.getParameter("delete")), pathS);
		}
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		List<User> listeComplete = ((List<User>) UserController.getAll(pathS));
		List<User> list = listeComplete;
		int noOfRecords = listeComplete.size();
		int noOfPages = noOfRecords % recordsPerPage != 0 ? noOfRecords / recordsPerPage + 1
				: noOfRecords / recordsPerPage;
		if (recordsPerPage < listeComplete.size()) {
			if (page == noOfPages) {
				list = listeComplete.subList((page - 1) * recordsPerPage, listeComplete.size());
			} else {
				list = listeComplete.subList((page - 1) * recordsPerPage, recordsPerPage * page);
			}
		}
		request.setAttribute("users", list);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		RequestDispatcher rd = this.getServletContext().getNamedDispatcher(forward);
		rd.forward(request, response);
	}

}
