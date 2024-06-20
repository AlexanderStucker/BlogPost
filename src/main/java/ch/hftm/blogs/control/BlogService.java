package ch.hftm.blogs.control;

import java.util.List;

import ch.hftm.blogs.entity.Blog;
import ch.hftm.blogs.repository.AutorRepository;
import ch.hftm.blogs.repository.BlogRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@Dependent
public class BlogService {

    @Inject
    BlogRepository blogRepository;

    @Inject
    AutorRepository autorRepository;

    public List<Blog> getBlogs() {
        var blogs = blogRepository.listAll();
        Log.info("Returning " + blogs.size() + " blogs");
        return blogs;
    }

    @Transactional
    public void addBlog(Blog blog) {
        Log.info("Adding blog " + blog.getTitle());
        blogRepository.persist(blog);
    }

    @Transactional
    public void updateBlog(Long id, Blog updatedBlog){
        Blog existingBlog = blogRepository.findById(id);
        existingBlog.setTitle(updatedBlog.getTitle());
        existingBlog.setContent(updatedBlog.getContent());
        blogRepository.persist(existingBlog);
        }

    @Transactional
    public void partialUpdateBlog(Long id, Blog partialUpdatedBlog){
        // vorhandener Blog mit der ID suchen
        Blog existingBlog = blogRepository.findById(id);
        // schauen was vom Blog ersetzt wird, und diesen ersetzen
        if(partialUpdatedBlog.getTitle() != null){
            existingBlog.setTitle(partialUpdatedBlog.getTitle());
        }        
        if(partialUpdatedBlog.getContent() != null){
            existingBlog.setContent(partialUpdatedBlog.getContent());
        }
        blogRepository.persist(existingBlog);
    }

    @Transactional
    public void deleteBlog(String title) {
        // Suche den Eintrag anhanden des Titels
        Blog blogToDelete = blogRepository.find("title", title).firstResult();
        // Falls es den Blog findet, diesen löschen
        if(blogToDelete != null){
            Log.info("Deleting blog " + blogToDelete.getTitle());
            blogRepository.delete(blogToDelete);
            // Falls nicht, soll es ein 404 zurückgeben
        }else{
            Log.info("Blog not found");
            throw new WebApplicationException("Blog with title not found.", 404);
            }
        }
}