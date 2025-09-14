package com.example.demo.Services;

import com.example.demo.dto.SearchServiceDTO;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

   private ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
         this.productRepository = productRepository;
    }

    public Page<Product> search(String query, int pageSize, int pageNumber){

        Sort sort = Sort.by("title").ascending();
        Pageable pageble = PageRequest.of(pageSize, pageNumber, sort);
        return productRepository.findByTitleContaining(query, pageble );
    }



}
