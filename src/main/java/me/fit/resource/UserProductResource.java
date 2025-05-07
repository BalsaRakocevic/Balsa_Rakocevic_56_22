
package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.models.User;
import me.fit.models.Product;

import jakarta.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;

@Path("/user-product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserProductResource {

    @Inject
    EntityManager em;

    @POST
    @Path("/add")
    @Transactional
    public Response addUserWithProducts(User user) {

        if (user.getProducts() != null) {
            
            for (Product p : user.getProducts()) {
                if (p.getProductID() == null) {
                    em.persist(p);
                } else {
                    p = em.merge(p);
                }
            }
        }
        em.persist(user);
        return Response.ok(user).build();
    }

    @GET
    @Path("/all")
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}
