package com.example.flashcash.service;


import com.example.flashcash.model.User;
import com.example.flashcash.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


      private final UserRepository userRepository;
      private final PasswordEncoder passwordEncoder;

      public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;

      }




      public User register(String firstName, String lastName, String email, String password){

            String hashedPassword = passwordEncoder.encode(password);

            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(hashedPassword);

            return userRepository.save(user);
      }

      public User login(String email, String password) {

                  User user = userRepository.findUserByMail(email)
                          .orElseThrow(() -> new IllegalArgumentException("Wrong credentials"));

                  if (!passwordEncoder.matches(password, user.getPassword())) {
                        throw new IllegalArgumentException("Wrong credentials");
                  }
                  return user;
            }
      }


