package ch.hftm.blogs.boundary;

import java.util.List;

import ch.hftm.blogs.control.BlogService;
import ch.hftm.blogs.entity.Blog;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("blogs")
public class BlogRessource {

  @Inject
  BlogService blogService;

  @GET
  public List<Blog> getBlogs(){
    return blogService.getBlogs();
  }

  @POST
  public void addBlog(Blog blog){
    blogService.addBlog(blog);
  }
  
  @PUT
  @Path("{id}")
  public void updateBlog(Long id, Blog updatedBlog){
    blogService.updateBlog(id, updatedBlog);
    }
    
  @DELETE
  @Path("{title}")
  public void deleteBlog(@PathParam("title") String title){
    blogService.deleteBlog(title);
    }
}
