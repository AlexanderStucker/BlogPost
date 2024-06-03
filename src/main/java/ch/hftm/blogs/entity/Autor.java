package ch.hftm.blogs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
  
}
