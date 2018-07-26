package com.carlos.api;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.carlos.models.StatusMessage;
import com.carlos.models.User;
import com.carlos.persistence.UserEM;

@Path("/users")
public class UsersAPI extends JSONService {
	private static Logger logger = Logger.getLogger("User");

	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	@GET

	public Response getLista(@HeaderParam("token") String token) {
		int userId = this.getUserIdFromToken(token);
		if (userId <= 0) {
			StatusMessage statusMessage = new StatusMessage(Status.FORBIDDEN.getStatusCode(),
					"Access Denied for this functionality !!!");
			return Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build();
		} else {

			try {
				List<User> usuarios = UserEM.getInstance().getLista();
				if (usuarios != null)
					return Response.status(Status.OK.getStatusCode()).entity(usuarios).build();
				else
					return Response.status(Status.NOT_FOUND.getStatusCode())
							.entity("no hay usuarios en la base de datos").build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode())
						.entity("Ha habido un error al pedir la lista de usuarios").build();
			}
		}

	}
}

/*
 * @Path("")
 * 
 * @Produces(MediaType.APPLICATION_JSON)
 * 
 * @GET public List<User> getUsuarios() {
 * logger.info("Estoy enviando lista usuarios ..."); return usuarios; } }
 */
/*
 * @Path("")
 * 
 * @POST
 * 
 * @Consumes(MediaType.APPLICATION_JSON)
 * 
 * @Produces(MediaType.APPLICATION_JSON) public int addUsuario(User
 * nuevoUsuario) { int nuevoId = (int) System.currentTimeMillis();
 * nuevoUsuario.setUid(nuevoId); usuarios.add(nuevoUsuario); return nuevoId; }
 * 
 * @Path("/{idusuario}")
 * 
 * @Produces(MediaType.APPLICATION_JSON)
 * 
 * @GET public User getUsuario(@PathParam(value = "idusuario") int idu) {
 * 
 * User unUsuario = null;
 * 
 * for (User cadaUsuario : usuarios) { if (cadaUsuario.getUid() == idu) {
 * unUsuario = cadaUsuario; break; } }
 * 
 * return unUsuario; }
 * 
 * @Path("/{idusuario}")
 * 
 * @Produces(MediaType.APPLICATION_JSON)
 * 
 * @DELETE public Response deleteUsuario(@HeaderParam("token") String
 * token, @PathParam(value = "idusuario") int idu) {
 * 
 * int userId = this.getUserIdFromToken(token);
 * 
 * if (userId <= 0) { StatusMessage statusMessage = new
 * StatusMessage(Status.FORBIDDEN.getStatusCode(),
 * "Access Denied for this functionality !!!"); return
 * Response.status(Status.FORBIDDEN.getStatusCode()).entity(statusMessage).build
 * (); } else { boolean isOk = false; try { User uToDelete = new User();
 * uToDelete.setUid(idu); isOk = UserEM.getInstance().deleteUser(uToDelete);
 * return Response.status(Status.OK.getStatusCode()).entity(isOk).build(); }
 * catch (Exception e) { e.printStackTrace(); return
 * Response.status(Status.INTERNAL_SERVER_ERROR.getStatusCode())
 * .entity("Ha habido un error al guardar el usuario").build(); } }
 * 
 * }
 * 
 * @Path("/{idusuario}")
 * 
 * @Consumes(MediaType.APPLICATION_JSON)
 * 
 * @Produces(MediaType.APPLICATION_JSON)
 * 
 * @PUT public boolean actualizarUsuario(@PathParam(value = "idusuario") int
 * idU, User userAActualizar) { boolean isOk = false;
 * 
 * if (userAActualizar.getUid() == idU) {
 * 
 * for (User cadaUsuario : usuarios) { if (cadaUsuario.getUid() == idU) {
 * usuarios.remove(cadaUsuario); usuarios.add(userAActualizar); isOk = true;
 * break; } }
 * 
 * }
 * 
 * return isOk; }
 * 
 * }
 */