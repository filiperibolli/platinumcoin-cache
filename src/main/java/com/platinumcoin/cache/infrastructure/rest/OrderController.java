package com.platinumcoin.cache.infrastructure.rest;

import com.platinumcoin.cache.application.domain.Order;
import com.platinumcoin.cache.application.usecase.CreateOrderUseCase;
import com.platinumcoin.cache.application.usecase.FindOrderUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
@Validated
@RequiredArgsConstructor
public class OrderController {
    private final CreateOrderUseCase createOrderUseCase;
    private final FindOrderUseCase findOrderUseCase;

    @PostMapping
    public ResponseEntity<Order> createOrder(
            @RequestHeader("X-Request-Id") String requestId,
            @RequestHeader(value = "X-Idempotency-Key", required = false) String idemKey,
            @RequestBody @Valid Order order) {
        Order created = createOrderUseCase.execute(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable UUID id) {
        return findOrderUseCase.execute(id);
    }
}