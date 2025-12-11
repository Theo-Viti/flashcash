package com.example.flashcash.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Link { //Friends system
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      Integer id;

      @ManyToOne
      User user1;

      @ManyToOne
      User user2;
}
