package com.spring.boot.products.api.order.entities;

import com.spring.boot.products.api.product.entities.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrderProductKey.class)
@Entity(name = "order_products")
@Table(name = "order_products")
public class OrderProduct {

    @Id
    @Column(name = "order_id")
    private UUID orderId;

    @Id
    @Column(name = "product_id")
    private UUID productId;

    @Column(name = "product_price", columnDefinition = "numeric")
    private Integer productPrice;

    @Column(name = "product_quantity", columnDefinition = "numeric")
    private Integer productQuantity;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;




}
