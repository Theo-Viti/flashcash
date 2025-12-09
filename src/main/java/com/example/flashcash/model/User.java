package com.example.flashcash.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data //getters + setters + toString + equals + hashCode + empty constructor
@Entity
public class User {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer id;

      private String firstName;
      private String lastName;

      @Column(unique = true)
      private String email;
      private String password;

      @ManyToMany
      private List<Link> links;

      @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
      private UserAccount account;
}
