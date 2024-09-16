package com.spring.boot.products.api.category.entities;

import com.spring.boot.products.api.common.BaseEntity;
import com.spring.boot.products.api.product.entities.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "categories")
@Table(name = "categories")
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "category",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Product> products;
}
