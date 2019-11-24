package fr.dta.poei.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.dta.poei.entities.User;

/**
 * Servlet implementation class UserServlet
 */
//@WebServlet({ "/UserServlet", "/" })
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final Map<Integer, User> users = new HashMap<Integer, User>();
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
		Random r = new Random();
		int j = r.nextInt((2000 - 70) + 1) + 70;
		for (int i = 0; i < j; i++) {
			boolean b = (r.nextInt((10000000 - 0) + 1) + 0)%2==0;
			User user = new User();
			user.setActivate(b);
			user.setCreatedAt(LocalDateTime.now());
			user.setId(r.nextInt((10000000 - 0) + 1) + 0);
			user.setName(noms.get(r.nextInt((39 - 0) + 1) + 0));
			user.setLastName(prenom.get(r.nextInt((115 - 0) + 1) + 0));
			user.setPv(((float)r.nextInt((3000 - 0) + 1) + 0)/2);
			users.put(++User.sequence, user);
		}

		request.setAttribute("users", users);
//		session.invalidate(); pour deactiver la session
		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("userJsp");
		rd.forward(request, response);
	}


}
