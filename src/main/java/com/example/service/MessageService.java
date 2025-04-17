package com.example.service;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class MessageService {
    
    private AccountRepository accountRepository;
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository, AccountRepository accountRepository){
        this.messageRepository = messageRepository;
        this.accountRepository = accountRepository;
    }
    
     public Message creatMessage(Message message){
        Optional<Account> user = accountRepository.findById(message.getPostedBy());
        if (message.getMessageText().isBlank() || message.getMessageText().length() > 255 || user.isPresent() == false) {  //no real user
         return null;
     }

     return messageRepository.save(message);
 }

    public List<Message> getMessages() {

        return messageRepository.findAll();
    }

    public Message getMessageByID(Integer messageID){

        return messageRepository.findByPostedBy(messageID);
      }
    public int deleteMessageByID(Integer messageID){
         if(messageRepository.existsById(messageID)){
                messageRepository.deleteById(messageID);
                return 1;
         }
        return 0;
      }

}
