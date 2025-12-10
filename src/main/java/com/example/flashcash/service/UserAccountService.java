package com.example.flashcash.service;


import com.example.flashcash.model.User;
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

            if (amount <= 0) { //Positive deposit amount check
                  throw new IllegalArgumentException("Deposit amount must be positive");
            }
            UserAccount account = userAccountRepository.findById(accountId) //Account check
                    .orElseThrow(() -> new RuntimeException("Account not found"));

            account.plus(amount);

            return userAccountRepository.save(account);
            }


      }

//      public UserAccount withdraw(Integer accountId, double amount) {
//
//      }
//
//      public void transfer(Integer fromAccountId, Integer toAccountId, double amount){
//
//      }

