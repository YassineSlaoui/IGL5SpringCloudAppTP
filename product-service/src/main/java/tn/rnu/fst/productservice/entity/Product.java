package tn.rnu.fst.productservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


import java.io.Serializable;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Product implements Serializable {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private int stock;
}


