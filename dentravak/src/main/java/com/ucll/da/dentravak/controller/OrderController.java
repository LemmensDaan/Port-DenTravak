package com.ucll.da.dentravak.controller;

import java.net.URI;
import java.util.List;

import com.ucll.da.dentravak.repository.SandwichRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.ucll.da.dentravak.model.Order;
import com.ucll.da.dentravak.repository.OrderRepository;

@RestController
public class OrderController {

    private final OrderRepository repository;

    OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/orders")
    List<Order> all() {
        return repository.findAll();
    }


    @GetMapping("/orders/{id}")
    Order one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    @PostMapping("/orders")
    ResponseEntity<Order> save(@RequestBody Order order) {
        Order saved = repository.save(order);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}