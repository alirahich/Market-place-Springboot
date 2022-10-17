package com.Auth.Repository;
import com.Auth.Entities.Mail;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MailRepository extends MongoRepository<Mail,String> {
    public Mail findByUsername(String username);
}
