package com.platinumcoin.cache.application.gateway.impl;

import com.platinumcoin.cache.application.domain.Order;
import com.platinumcoin.cache.application.gateway.OrderGateway;
import com.platinumcoin.cache.infrastructure.mapper.OrderMapper;
import com.platinumcoin.cache.infrastructure.persistence.OrderRepository;
import com.platinumcoin.cache.infrastructure.persistence.RedisCache;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderGatewayImpl implements OrderGateway {

    private final OrderRepository repository;
    private final RedisCache cache;

    @Override
    @Transactional
    public Order save(Order order) {
        var savedEntity = repository.save(OrderMapper.toEntity(order));
        var savedDomain = OrderMapper.toDomain(savedEntity);
        cache.put(savedDomain.getId().toString(), OrderMapper.toCache(savedDomain));
        return savedDomain;
    }

    @Override
    public Optional<Order> findById(UUID id) {
        String key = id.toString();

        return cache.get(key)
                .map(OrderMapper::toDomain)
                .or(() -> repository.findById(id)
                        .map(OrderMapper::toDomain)
                        .map(order -> {
                            cache.put(key, OrderMapper.toCache(order));
                            return order;
                        }));
    }
}