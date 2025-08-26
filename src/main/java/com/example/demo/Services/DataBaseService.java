package com.example.demo.Services;

import com.example.demo.exceptions.ProductNotFoundException;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dataBaseService")
public class DataBaseService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public DataBaseService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
       Optional<Product> productOptional = productRepository.findById(id);
       if(productOptional.isPresent()){
           return productOptional.get();
       }
       throw new ProductNotFoundException("Product not found");
    }

    @Override
    public List<Product> getAllProducts() {
       List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public Product createProduct(Product product) {

        Category categoryDB = categoryRepository.findByName(product.getCategory().getName());

        if(categoryDB == null){
//            Category category = new Category();
//            category.setName(getName());
//            categoryDB = categoryRepository.save(category);
            categoryDB =  categoryRepository.save(product.getCategory());
        }
        product.setCategory(categoryDB);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
     Category categoryFromDB = categoryRepository.findByName(product.getCategory().getName());

     if(categoryFromDB == null){
         Category newCategory = new Category();
         newCategory.setName(product.getCategory().getName());
         categoryFromDB = newCategory;
     }
     product.setCategory(categoryFromDB);

     return productRepository.save(product);
    }

    @Override
    public ResponseEntity<Product> deleteProduct(Long id) throws ProductNotFoundException {
//        Category categoryFromDB = categoryRepository.findByName(product.getCategory().getName());

       Optional<Product> productOptional = productRepository.findById(id);

       if(productOptional.isPresent()){
           productRepository.deleteById(id);
           return ResponseEntity.ok(productOptional.get());
       }
      throw new ProductNotFoundException("Product Not Found");

    }
}
