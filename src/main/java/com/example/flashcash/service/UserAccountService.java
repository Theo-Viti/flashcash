package com.example.flashcash.service;


import com.example.flashcash.model.UserAccount;
import com.example.flashcash.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

      //Bean
      private final UserAccountRepository userAccountRepository;

      //Constructor
      public UserAccountService (UserAccountRepository userAccountRepository){
            this.userAccountRepository = userAccountRepository;
      }

      //Methods
      public UserAccount deposit(Integer accountId, double amount){
            deposit(accountId, amount);

      }

}
