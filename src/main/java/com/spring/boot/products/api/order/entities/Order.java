package com.spring.boot.products.api.order.entities;

import com.spring.boot.products.api.common.BaseEntity;
import com.spring.boot.products.api.order.enums.OrderStatus;
import com.spring.boot.products.api.user.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
@Table(name = "orders")
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "total_amount", columnDefinition = "numeric")
    private Integer totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", columnDefinition = "varchar(255) default 'Created'")
    private OrderStatus orderStatus = OrderStatus.Created;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
