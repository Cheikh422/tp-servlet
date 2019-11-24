package fr.dta.poei.filtres;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.dta.poei.entities.User;

/**
 * Servlet Filter implementation class ConnexionFiltre
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/*" })
public class ConnexionFiltre implements Filter {

	/**
	 * Default constructor.
	 */
	public ConnexionFiltre() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String path = ((HttpServletRequest) request).getServletPath();
		if(path.startsWith("/api")) {
			chain.doFilter(request, response);
		}
		else {
			HttpServletRequest requestSession = (HttpServletRequest) request;
			HttpSession session = requestSession.getSession();
			String user = (String) session.getAttribute("User_session");
			String foward = "login";
			if (request.getServletContext().getAttribute("users") == null) {
				Map<Integer, User> userFix = ficture();
				request.getServletContext().setAttribute("users", userFix);
			}
			if (user == null) {
				if (request.getParameter("cnxsubmit") != null) {
					String username = request.getParameter("username");
					session.setAttribute("User_session", username);
					foward = "IndexServlet";
				}
				request.getServletContext().getNamedDispatcher(foward).forward(requestSession, response);

				
			}else {

				chain.doFilter(request, response);
			}
		}
	}
	

	private Map<Integer, User> ficture() {
		Map<Integer, User> userFix = new HashMap<Integer, User>();
		List<String> prenom = new ArrayList<>();
		prenom.add("Emma");
		prenom.add("Jade");
		prenom.add("Louise");
		prenom.add("Alice");
		prenom.add("Chloé");
		prenom.add("Lina");
		prenom.add("Léa");
		prenom.add("Rose");
		prenom.add("Anna");
		prenom.add("Mila");
		prenom.add("Inès");
		prenom.add("Ambre");
		prenom.add("Julia");
		prenom.add("Mia");
		prenom.add("Léna");
		prenom.add("Manon");
		prenom.add("Gabriel");
		prenom.add("Raphaël");
		prenom.add("Léo");
		prenom.add("Louis");
		prenom.add("Lucas");
		prenom.add("Adam");
		prenom.add("Arthur");
		prenom.add("Jules");
		prenom.add("Hugo");
		prenom.add("Maël");
		prenom.add("Liam");
		prenom.add("Ethan");
		prenom.add("Paul");
		prenom.add("Nathan");
		prenom.add("Gabin");
		prenom.add("Sacha");
		prenom.add("Noah");
		prenom.add("Tom");
		prenom.add("Mohamed");
		prenom.add("Aaron");
		prenom.add("Théo");
		prenom.add("Noé");
		prenom.add("Victor");
		prenom.add("Martin");
		prenom.add("Mathis");
		prenom.add("Timéo");
		prenom.add("Nolan");
		prenom.add("Enzo");
		prenom.add("Éden");
		prenom.add("Axel");
		prenom.add("Antoine");
		prenom.add("Léon");
		prenom.add("Marius");
		prenom.add("Robin");
		prenom.add("Valentin");
		prenom.add("Clément");
		prenom.add("Baptiste");
		prenom.add("Tiago");
		prenom.add("Rayan");
		prenom.add("Samuel");
		prenom.add("Amir");
		prenom.add("Augustin");
		prenom.add("Naël");
		prenom.add("Maxime");
		prenom.add("Maxence");
		prenom.add("Gaspard");
		prenom.add("Eliott");
		prenom.add("Alexandre");
		prenom.add("Isaac");
		prenom.add("Mathéo");
		prenom.add("Yanis");
		prenom.add("Évan");
		prenom.add("Simon");
		prenom.add("Malo");
		prenom.add("Nino");
		prenom.add("Marceau");
		prenom.add("Kylian");
		prenom.add("Thomas");
		prenom.add("Ibrahim");
		prenom.add("Imran");
		prenom.add("Ayden");
		prenom.add("Lenny");
		prenom.add("Camille");
		prenom.add("Lyam");
		prenom.add("Kaïs");
		prenom.add("Oscar");
		prenom.add("Naïm");
		prenom.add("Sohan");
		prenom.add("Côme");
		prenom.add("Milo");
		prenom.add("Noa");
		prenom.add("Ilyes");
		prenom.add("Noam");
		prenom.add("Diego");
		prenom.add("Ismaël");
		prenom.add("Léandre");
		prenom.add("Soan");
		prenom.add("Mathys");
		prenom.add("Alexis");
		prenom.add("Lorenzo");
		prenom.add("Esteban");
		prenom.add("Owen");
		prenom.add("Youssef");
		prenom.add("Ilyan");
		prenom.add("William");
		prenom.add("Adrien");
		prenom.add("Ayoub");
		prenom.add("Jean");
		prenom.add("David");
		prenom.add("Ali");
		prenom.add("Adem");
		prenom.add("Wassim");
		prenom.add("Logan");
		prenom.add("Sandro");
		prenom.add("Pablo");
		prenom.add("Antonin");
		prenom.add("Joseph");
		prenom.add("Benjamin");
		prenom.add("Noham");
		prenom.add("Kenzo");
		List<String> noms = new ArrayList<>();
		noms.add("Martin");
		noms.add("Bernard");
		noms.add("Thomas");
		noms.add("Petit");
		noms.add("Robert");
		noms.add("Richard");
		noms.add("Durand");
		noms.add("Dubois");
		noms.add("Moreau");
		noms.add("Laurent");
		noms.add("Simon");
		noms.add("Michel");
		noms.add("Lefebvre");
		noms.add("Leroy");
		noms.add("Roux");
		noms.add("Bertrand");
		noms.add("Morel");
		noms.add("Fournier");
		noms.add("Girard");
		noms.add("Bonnet");
		noms.add("Dupont");
		noms.add("Lambert");
		noms.add("Fontaine");
		noms.add("Rousseau");
		noms.add("Vincent");
		noms.add("Muller");
		noms.add("Lefevre");
		noms.add("Faure");
		noms.add("Andre");
		noms.add("Mercier");
		noms.add("Blanc");
		noms.add("Guerin");
		noms.add("Boyer");
		noms.add("Garnier");
		noms.add("Chevalier");
		noms.add("Francois");
		noms.add("Legrand");
		noms.add("Gauthier");
		noms.add("Garcia");
		noms.add("Perrin");
		List<String> voies = new ArrayList<>();
		voies.add("Rue");
		voies.add("Avenue");
		voies.add("Cours");
		voies.add("Allée");
		List<String> villeCp = new ArrayList<>();
		villeCp.add("Éloise	01200");
		villeCp.add("Riboux	13780");
		villeCp.add("Buxeuil	37160");
		villeCp.add("Paray-Vieille-Poste	94390");
		Random r = new Random();
		for (int i = 0; i < 3500; i++) {
			User user = new User();
			String adresse = String.format("%d %s %s %s, %s", r.nextInt((115 - 0) + 1) + 0,
					voies.get(r.nextInt((3 - 0) + 1) + 0), noms.get(r.nextInt((39 - 0) + 1) + 0),
					prenom.get(r.nextInt((115 - 0) + 1) + 0), villeCp.get(r.nextInt((3 - 0) + 1) + 0));
			String nom = noms.get(r.nextInt((39 - 0) + 1) + 0);
			String lastName = prenom.get(r.nextInt((115 - 0) + 1) + 0);
			String email = String.format("%s@%s.fr", nom, lastName);
			user.setId(++User.sequence);
			user.setFirstName(nom);
			user.setLastName(lastName);
			user.setUserName(nom.toLowerCase());
			user.setAdresse(adresse);
			user.setEmail(email.toLowerCase());
			user.setPhotoUrl("img/paris.jpg");
			userFix.put(user.getId(), user);
		}
		return userFix;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
