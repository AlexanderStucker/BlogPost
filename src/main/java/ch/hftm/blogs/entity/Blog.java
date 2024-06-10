package ch.hftm.blogs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Blog {

  @Id @GeneratedValue
  private Long id;
  
  private String title;
  private String content;

  @ManyToOne
  private Autor autor; 

  public Blog(String title, String content, Autor autor) {
    this.title = title;
    this.content = content;
    this.autor = autor;
  }

}
