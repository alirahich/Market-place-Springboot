package com.marketplace.models;

import lombok.*;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Categories {
    @Id
    private String id;
    private String nom;
    private String description;
}






