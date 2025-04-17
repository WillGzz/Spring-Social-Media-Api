package com.example.service;
import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
     
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Account registerAccount (Account account){
        Optional<Account> optionalAccount = accountRepository.findByUsername(account.getUsername());
        if (account.getUsername().isBlank() || account.getPassword().length() < 4 || optionalAccount.isPresent()){

            return null;
        }   
        
    return accountRepository.save(account);

  }

  public Account accountLogin (Account account){

    Optional<Account> retrievedAccount = accountRepository.findByUsername(account.getUsername());
    if (retrievedAccount.isPresent()) {
       if (retrievedAccount.get().getUsername().equals(account.getUsername()) && retrievedAccount.get().getPassword().equals(account.getPassword())){
                         return retrievedAccount.get();
       }

    }

    return null;

   }

  }
   

