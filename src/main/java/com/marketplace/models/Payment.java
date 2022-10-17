package com.marketplace.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter @Document
public class Payment {
    @Id
    private String id;
    private String from;
    private String to;
    private long amount;
    private String produit;
}




