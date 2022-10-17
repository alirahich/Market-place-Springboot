package com.Auth.Entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter @Document
public class Code {
    @Id
    private String id;
    private String code;
    private AppUser user;
}


