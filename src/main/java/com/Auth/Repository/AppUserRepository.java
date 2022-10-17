package com.Auth.Repository;

import com.Auth.Entities.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppUserRepository extends MongoRepository<AppUser,String> {
    AppUser findByUsername(String username);
}
