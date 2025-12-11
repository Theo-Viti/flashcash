package com.example.flashcash.service;


import com.example.flashcash.model.UserAccount;
import com.example.flashcash.repository.UserAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

      //Bean
      private final UserAccountRepository userAccountRepository;

      //Constructor
      public UserAccountService(UserAccountRepository userAccountRepository) {
            this.userAccountRepository = userAccountRepository;
      }

      //Methods
      public UserAccount deposit(Integer accountId, double amount) {

            if (amount <= 0) { //Positive deposit amount check
                  throw new IllegalArgumentException("Deposit amount must be positive");
            }
            UserAccount userAccount = userAccountRepository.findById(accountId) //Account check
                    .orElseThrow(() -> new RuntimeException("Account not found"));

            userAccount.plus(amount);

            return userAccountRepository.save(userAccount);
      }

      public UserAccount withdraw(Integer accountId, double amount) {

            if (amount <= 0) {
                  throw new IllegalArgumentException("Withdraw amount must be positive"); //IAE = wrong paramater
            }

            UserAccount userAccount = userAccountRepository.findById(accountId)
                    .orElseThrow(() -> new RuntimeException("Account not found")); //Internal error

            if (userAccount.getAmount() < amount) {
                  throw new IllegalArgumentException("Insufficient balance");
            }
            userAccount.minus(amount);

            return userAccountRepository.save(userAccount);
      }

      @Transactional // @Transactional ensures the debit and credit happen atomically; if any step fails, the entire transfer is rolled back.
      public void transfer(Integer fromAccountId, Integer toAccountId, double amount) {

            if (amount <= 0) {
                  throw new IllegalArgumentException("Transfer amount must be positive");
            }

            if (fromAccountId.equals(toAccountId)) { //Not necessary but recommanded
                  throw new IllegalArgumentException("Cannot transfer to the same account");
            }

            UserAccount fromAccount = userAccountRepository.findById(fromAccountId)
                    .orElseThrow(() -> new RuntimeException("Source account not found"));

            UserAccount toAccount = userAccountRepository.findById(toAccountId)
                    .orElseThrow(() -> new RuntimeException("Destination account not found"));

            if (fromAccount.getAmount() < amount) {
                  throw new IllegalArgumentException("Insufficient balance for transfer");
            }

            fromAccount.minus(amount);
            toAccount.plus(amount);

            userAccountRepository.save(fromAccount);
            userAccountRepository.save(toAccount);
      }

}

