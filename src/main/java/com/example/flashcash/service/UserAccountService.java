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
            UserAccount userAccount = userAccountRepository.findById(ccountId) //Account check
                    .orElseThrow(() -> new RuntimeException("Account not found"));

            userAccount.plus(amount); //Account ou useraccount?

            return userAccountRepository.save(userAccount);
            }


      }

      public UserAccount withdraw(Integer accountId, double amount) {

      if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
      }
      UserAccount userAccount


      }
//
//      public void transfer(Integer fromAccountId, Integer toAccountId, double amount){
//
//      }

