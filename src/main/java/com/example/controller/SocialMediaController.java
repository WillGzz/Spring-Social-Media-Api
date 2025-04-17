package com.example.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;
import java.util.List;


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

    @PostMapping("/messages")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message createdMessage = messageService.creatMessage(message);
     
        if (createdMessage == null ){
            return ResponseEntity.status(400).build();
        }  
    
        return ResponseEntity.status(200).body(createdMessage);
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getMessages() {
        return ResponseEntity.status(200).body(messageService.getMessages());
    }

    @GetMapping("messages/{message_id}")
    public ResponseEntity<Message> getMessage(@PathVariable Integer message_id) {
        return ResponseEntity.status(200).body(messageService.getMessageByID(message_id));
    }

    @DeleteMapping("messages/{message_id}")
    public ResponseEntity<Integer> deleteMessage(@PathVariable Integer message_id) {
        int deleted = messageService.deleteMessageByID(message_id);
        return deleted == 1 ? ResponseEntity.status(200).body(deleted) : ResponseEntity.status(200).build(); 
    }

    @PatchMapping("messages/{message_id}")
    public ResponseEntity<Integer> updateMessage(@PathVariable Integer message_id, @RequestBody Message message) {
        int updated = messageService.updateMessageByID(message_id, message.getMessageText());
        return updated == 1 ? ResponseEntity.status(200).body(updated) : ResponseEntity.status(400).build(); 
    }

    @GetMapping("/accounts/{account_id}/messages")
    public ResponseEntity<List<Message>> getMessagesByID(@PathVariable Integer account_id) {
        return ResponseEntity.status(200).body(messageService.getAllMessagesByID(account_id));
    }
}
