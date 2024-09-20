package ch.hftm.blogs.boundary;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;

import ch.hftm.blogs.control.BlogService;
import ch.hftm.blogs.entity.Blog;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import io.quarkus.logging.Log;

@Path("blogs")
public class BlogRessource {

  @Inject
  BlogService blogService;

  @GET
  @PermitAll
  @Operation(summary = "Auflistung aller Blog-Einträge")
  public List<Blog> getBlogs(){
    Log.info("Request to fetch all blog entries received");
    Log.debug("Debug message");
    Log.error("Bug!");
    List<Blog> blogs = blogService.getBlogs();
    Log.infof("TEST Returning %d blogs", blogs.size());
    return blogs;
  }

  @POST
  @RolesAllowed({"user", "admin"})
  @Operation(summary = "Erstellen eines Blog-Eintrags")
  public void addBlog(Blog blog){
    blogService.addBlog(blog);
  }
  
  @PUT
  @RolesAllowed({"user", "admin"})
  @Operation(summary = "Vollständige Aktualisierung eines Blog-Eintrags")
  @Path("{id}")
  public void updateBlog(Long id, Blog updatedBlog){
    blogService.updateBlog(id, updatedBlog);
    }
  
  @PATCH
  @RolesAllowed({"user", "admin"})
  @Operation(summary = "Teilweise Aktualisierung eines Blog-Eintrags")
  @Path("{id}")
  public Response updateBlogPartial(@PathParam("id") Long id, Blog update){
    if(update != null){
      blogService.updateBlog(id, update);
    } else{
      return Response.status(Status.NOT_FOUND).entity("Blog nicht aktualisiert").build(); 
    }
    return Response.status(Status.OK).entity("Blog aktualisiert").build();
  }

  @DELETE
  @RolesAllowed("admin") // Probably Going to change in the Future
  @Operation(summary = "Löschen eines Blog-Eintrags")
  @Path("{title}")
  public void deleteBlog(@PathParam("title") String title){
    blogService.deleteBlog(title);
    }
}
