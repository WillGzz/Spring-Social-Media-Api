package com.example.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.entity.Message;
import java.util.Optional;
import com.example.service.AccountService;
import com.example.service.MessageService;


@RestController
public class SocialMediaController {

    private AccountService accountService;
    private MessageService  messageService;

    public SocialMediaController(AccountService accountService, MessageService messageService) { //autowired not necessary if you only have one constructor
        this.accountService = accountService;
        this.messageService = messageService;
    }

    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody Account account) {

        Account registeredAccount = accountService.registerAccount(account);
        if (registeredAccount == null && !account.getUsername().isBlank()){
            return ResponseEntity.status(409).build();
        }  
       else if (registeredAccount == null){
            return ResponseEntity.status(400).build();
       }
    
        return ResponseEntity.status(200).body(registeredAccount);
    }

    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody Account account) {
        Account accountLogin = accountService.accountLogin(account);
     
        if (accountLogin == null ){
            return ResponseEntity.status(401).build();
        }  
    
        return ResponseEntity.status(200).body(accountLogin);
    }

}
