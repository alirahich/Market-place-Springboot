package com.Auth.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;

@Data @AllArgsConstructor@NoArgsConstructor
@Document
public class AppUser {
    @Id
    private String id;
    private String username;
    private String password;
    private int active;
    private Collection<AppRole> appRoles = new ArrayList<>();
}


