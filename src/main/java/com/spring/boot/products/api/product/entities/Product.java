package com.spring.boot.products.api.product.entities;

import com.spring.boot.products.api.category.entities.Category;
import com.spring.boot.products.api.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
@Table(name = "products")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_description", columnDefinition = "text", nullable = false)
    private String shortDescription;

    @Column(columnDefinition = "text", nullable = false)
    private String description;

    @Column(name = "product_price",
            columnDefinition = "decimal",
            precision = 10,
            scale = 2,
            nullable = false
            // TODO: Mozda budes trebao transformer ovde da dodas
    )
    private Integer productPrice;

    @Column(name = "product_quantity", nullable = false)
    private Integer productQuantity;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;


}
