package com.example.demo.repositories;

import com.example.demo.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    public Product save(Product product);
    public Optional<Product> findById(Long id);
    public List<Product> findAll();
    public void deleteById(Long id);

    Page<Product> findByTitleContaining(String query, Pageable pageable);

    // JPA Query methods
    public List<Product> findByTitleAndPrice(String title, Double price);

    // HQL  Query
//    @Query("select p from Product p where p.id = :id");
//    public Product getProductDataHql(@Param("id") Long id);

    // Sql Query
    @Query(value = "select * from Product p where p.id = :id", nativeQuery = true)
    public Product getDataSql(@Param("id") Long id);


}
