package ch.hftm.initialization;

import ch.hftm.blogs.entity.Autor;
import ch.hftm.blogs.entity.Blog;
import ch.hftm.blogs.repository.AutorRepository;
import ch.hftm.blogs.repository.BlogRepository;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DataInitialization {


  @Inject
  BlogRepository blogRepository;

  @Inject 
  AutorRepository autorRepository;

    @Transactional
    public void init(@Observes StartupEvent event) {
            if (blogRepository.count() == 0) {
              Autor autor1 = new Autor("Stucker", "Alexander");
              autorRepository.persist(autor1);


              Blog blog1 = new Blog("Titel", "Content", autor1);
              Blog blog2 = new Blog("Titel 2", "Content2", autor1);
              blogRepository.persist(blog1);
              blogRepository.persist(blog2);
    }
  }
}
