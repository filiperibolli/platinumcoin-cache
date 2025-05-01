package com.platinumcoin.cache.infrastructure.mapper;

import com.platinumcoin.cache.application.domain.Order;
import com.platinumcoin.cache.infrastructure.persistence.entity.OrderCache;
import com.platinumcoin.cache.infrastructure.persistence.entity.OrderEntity;

public class OrderMapper {
    private OrderMapper() {
    }

    public static OrderEntity toEntity(Order order) {
        if (order == null) return null;
        return OrderEntity.builder()
                .id(order.getId())
                .total(order.getTotal())
                .build();
    }

    public static Order toDomain(OrderEntity entity) {
        if (entity == null) return null;
        return Order.builder()
                .id(entity.getId())
                .total(entity.getTotal())
                .build();
    }

    public static OrderCache toCache(Order order) {
        if (order == null) return null;
        return OrderCache.builder()
                .id(order.getId())
                .total(order.getTotal())
                .build();
    }

    public static Order toDomain(OrderCache cache) {
        if (cache == null) return null;
        return Order.builder()
                .id(cache.getId())
                .total(cache.getTotal())
                .build();
    }
}
