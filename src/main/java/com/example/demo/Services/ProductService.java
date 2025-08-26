package com.example.demo.Services;

import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

   public Product getProductById(Long id) throws ProductNotFoundException;

   public List<Product> getAllProducts();

   public Product createProduct(Product product);

   public Product updateProduct(Product product);

   public ResponseEntity<Product> deleteProduct(Long id) throws ProductNotFoundException;


}
