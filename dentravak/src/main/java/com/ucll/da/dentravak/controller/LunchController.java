package com.ucll.da.dentravak.controller;

import java.net.URI;
import java.util.List;

import com.ucll.da.dentravak.model.Sandwich;
import com.ucll.da.dentravak.repository.SandwichRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class LunchController {

  private final SandwichRepository repository;

  LunchController(SandwichRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/sandwiches")
  List<Sandwich> all() {
    return repository.findAll();
  }

  @GetMapping("/sandwiches/{id}")
  Sandwich one(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new IllegalArgumentException());
  }

  @PostMapping("/sandwiches")
  ResponseEntity<Sandwich> save(@RequestBody Sandwich sandwich) {
    Sandwich saved = repository.save(sandwich);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @PutMapping("/sandwiches/{id}")
  public ResponseEntity<Sandwich> updateStudent(@RequestBody Sandwich sandwich, @PathVariable long id) {
    repository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    sandwich.setId(id);
    repository.save(sandwich);
    return ResponseEntity.noContent().build();
  }
}