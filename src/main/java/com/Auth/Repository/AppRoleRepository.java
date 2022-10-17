package com.Auth.Repository;

import com.Auth.Entities.AppRole;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AppRoleRepository extends MongoRepository<AppRole,String> {
    AppRole getByRole(String role);
}
