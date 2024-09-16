package com.spring.boot.products.api.order.entities;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductKey implements Serializable {

    private UUID orderId;

    private UUID productId;
}
