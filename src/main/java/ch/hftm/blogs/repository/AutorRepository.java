package ch.hftm.blogs.repository;

import ch.hftm.blogs.entity.Autor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AutorRepository implements PanacheRepository<Autor> {
  
}
