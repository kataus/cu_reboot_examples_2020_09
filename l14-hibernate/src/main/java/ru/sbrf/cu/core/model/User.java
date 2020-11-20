package ru.sbrf.cu.core.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id")
  private long id;

  @Column(name = "name")
  private String name;

  @OneToMany(targetEntity = Phone.class, fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private List<Phone> phones;

  public User() {
  }

  public User(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId( long id ) {
    this.id = id;
  }

  public List<Phone> getPhones() {
    return phones;
  }

  public void setPhones( List<Phone> phones ) {
    this.phones = phones;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
