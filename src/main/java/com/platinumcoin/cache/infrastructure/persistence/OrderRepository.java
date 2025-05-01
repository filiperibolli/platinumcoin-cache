package com.platinumcoin.cache.infrastructure.persistence;

import com.platinumcoin.cache.infrastructure.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository  extends JpaRepository<OrderEntity, UUID> {}
