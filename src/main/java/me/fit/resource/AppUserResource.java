package me.fit.resource;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import me.fit.models.AppUser;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Path("/appUser")
public class AppUserResource {

    @Inject
    EntityManager em;

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    public Response uploadFile(@QueryParam("id") Long id, @RestForm("fileName") String fileName, @RestForm("file") FileUpload file) {
        AppUser user = em.find(AppUser.class, id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
        }
        try {
            String folder = "uploads/";
            Files.createDirectories(Paths.get(folder));
            String path = folder + fileName;
            Files.copy(file.uploadedFile(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            user.setFilePath(path);
            em.merge(user);
            return Response.ok("File uploaded and path saved for user: " + user.getUsername()).build();
        } catch (IOException e) {
            return Response.serverError().entity("Error saving file: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") Long id) {
        AppUser user = em.find(AppUser.class, id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
        }
        return Response.ok(new UserWithFilePathDTO(user, user.getFilePath())).build();
    }

    public static class UserWithFilePathDTO {
        private AppUser user;
        private String filePath;

        public UserWithFilePathDTO(AppUser user, String filePath) {
            this.user = user;
            this.filePath = filePath;
        }

        public AppUser getUser() {
            return user;
        }

        public String getFilePath() {
            return filePath;
        }
    }
}