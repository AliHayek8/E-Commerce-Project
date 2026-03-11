package com.ecommerce.model;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "customers")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;


}
