package com.example.spring_boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot.models.Product;
import com.example.spring_boot.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<Product> saveProduct(@RequestBody @Valid Product product) {
		// Salvando e retornando o Product salvo na base de dados
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));

	}

	@GetMapping
	public ResponseEntity<List<Product>> getAll() {
		// Retornando todos os produtos
		return ResponseEntity.ok(productService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getOne(@PathVariable("id") Long id) {
		// Retornando um Produto especifico atráves do id
		return ResponseEntity.ok(productService.getOne(id));
	}

	@PutMapping
	public ResponseEntity<Product> update(@RequestBody @Valid Product product) {
		// Recebendo um Product atualizado e persistindo na base de dados
		return ResponseEntity.ok(productService.save(product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		// Procura o produto na base de dados, se existir, então elimina-o. Se não
		// existir, retorna um NOT_FOUND
		productService.delete(id);
		return ResponseEntity.ok("Product deleted successfuly");
	}

}
