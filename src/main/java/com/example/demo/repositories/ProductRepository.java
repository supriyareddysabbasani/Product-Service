package com.example.demo.repositories;

import com.example.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    public Product save(Product product);
    public Optional<Product> findById(Long id);
    public List<Product> findAll();
    public Product save(Long id, Product product);
    public void deleteById(Long id);
}
