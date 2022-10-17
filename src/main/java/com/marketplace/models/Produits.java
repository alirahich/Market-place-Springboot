package com.marketplace.models;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data @AllArgsConstructor @NoArgsConstructor @Setter @Getter
public class Produits {
    @Id
    private String id;
    private String User;
    private long price;
    private String description;
    private String label;
    private String image;
    private String Category;
}


