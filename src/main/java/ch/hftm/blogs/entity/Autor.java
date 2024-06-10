package ch.hftm.blogs.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Autor {

  @Id @GeneratedValue
  private Long id;

  private String lastName;
  private String firstName;

  @OneToMany
  private List<Blog> blogs;

  public Autor(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
  }
  
}
