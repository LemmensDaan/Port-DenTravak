package com.ucll.da.dentravak.controller;

import java.util.List;

import com.ucll.da.dentravak.model.Sandwich;
import com.ucll.da.dentravak.repository.SandwichRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

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
}