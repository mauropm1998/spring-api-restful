package com.example.spring_boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot.exceptions.EntityNotFoundException;
import com.example.spring_boot.models.Product;
import com.example.spring_boot.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	// Método para salvar um produto na base de dados	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	// Método para trazer todos os produtos
	public List<Product> getAll() {
		return productRepository.findAll();
	}
	
	// Método para trazer um produto pelo ID
	public Product getOne (Long id) {
		return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product " + id + " not found"));
	}
	
	// Método para atualizar um produto na base de dados
	public Product update (Product product) {
		return productRepository.save(product);
	}
	
	// Método para eliminar um produto
	public void delete (Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product " + id + " not found"));
		productRepository.delete(product);
	}

}
