package fr.dta.poei.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.dta.poei.entities.User;

@Path("/user")
public class UserService {
	private static final String CONTEXT = "users";

	private final ServletContext servletContext;

	private final Map<Integer, User> users;

	/**
	 * Constructor of User controller.
	 * 
	 * @param servletContext Injected Servlet Context.
	 */
	@SuppressWarnings("unchecked")
	public UserService(@Context final ServletContext servletContext) {
		// Store injected ServletContext.
		this.servletContext = servletContext;

		// Check if Map of Users exist, if not create it.
		if (this.servletContext.getAttribute(CONTEXT) == null) {
			this.servletContext.setAttribute(CONTEXT, new HashMap<Integer, User>() );
		}

		// Store context of users.
		this.users = (Map<Integer, User>) this.servletContext.getAttribute(CONTEXT);
	}
	


	/**
	 * Retrieve the collection resource of User in the response body.
	 * 
	 * @return Collection of User.
	 */
	@GET
	@Path("/all")
	public Response getAll() {
		final Collection<User> result = users.values();
		if (result != null) {
			return Response.ok(result).build();
		} else {
			return Response.noContent().build();
		}

	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(User user) {
		users.replace(user.getId(), user);
		return Response.ok(user).build();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(User user) {
		if (user.getId() == null) {
			user.setId(++User.sequence);
		}
		users.put(user.getId(), user);
		return Response.ok(user).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Integer id) {
		User user = users.get(id);
		if (user == null) {
			return Response.noContent().build();
		} else {
			return Response.ok(user).build();
		}
	}


	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response delete(@PathParam("id") Integer id) {
		User user = users.get(id);
		if (user == null) {
			return Response.noContent().build();
		} else {
			users.remove(id);
			return Response.ok(user).build();
		}
	}

}
