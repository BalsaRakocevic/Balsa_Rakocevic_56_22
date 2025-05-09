
package me.fit.resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.models.AppUser;
import me.fit.models.Product;

@Path("/user-product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserProductResource {

    @Inject
    EntityManager em;

    @POST
    @Path("/add")
    @Transactional
    public Response addUserWithProducts(AppUser user) {

        em.persist(user);
        return Response.ok(user).build();
    }

    @GET
    @Path("/all")
    public List<AppUser> getAllUsers() {
        return em.createNamedQuery(AppUser.GET_ALL_USERS, AppUser.class).getResultList();
    }
}
