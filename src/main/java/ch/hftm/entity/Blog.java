package ch.hftm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

  public Blog(String title, String content) {
    this.title = title;
    this.content = content;
  }

}
