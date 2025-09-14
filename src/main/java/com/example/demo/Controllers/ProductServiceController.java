package com.example.demo.Controllers;

import com.example.demo.Services.FakeStoreAPIService;
import com.example.demo.Services.ProductService;
import com.example.demo.dto.CreateFrontendRequestDTO;
import com.example.demo.dto.ErrorDTO;
import com.example.demo.dto.UpdateFrontendRequestDTO;
import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductServiceController {

    private ProductService productService;

    public ProductServiceController(@Qualifier("dataBaseService") ProductService productService) {
        this.productService = productService;
}

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
       return productService.getProductById(id);
    }
    @GetMapping("/products")
    public List<Product> getAllProducts() {
       return productService.getAllProducts();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateFrontendRequestDTO createFrontendRequestDTO){
        Product product = new Product();
        product.setTitle(createFrontendRequestDTO.getTitle());
        product.setPrice(Double.valueOf(createFrontendRequestDTO.getPrice()));
        product.setDescription(createFrontendRequestDTO.getDescription());
        product.setImageURL(createFrontendRequestDTO.getImageURL());

        Category category = new Category();
        category.setName(createFrontendRequestDTO.getCategory());
        product.setCategory(category);

        return productService.createProduct(product);

    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody UpdateFrontendRequestDTO updateFrontendRequestDTO){
        Product product = new Product();
//        product.setId(updateFrontendRequestDTO.getId());
        product.setTitle(updateFrontendRequestDTO.getTitle());
        product.setDescription(updateFrontendRequestDTO.getDescription());
        product.setPrice(Double.valueOf(updateFrontendRequestDTO.getPrice()));
        product.setImageURL(updateFrontendRequestDTO.getImageURL());

        Category category = new Category();
        category.setName(updateFrontendRequestDTO.getCategory());
        product.setCategory(category);

        return productService.updateProduct(product);


    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.deleteProduct(id);

    }



}
