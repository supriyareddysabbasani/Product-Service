package com.example.demo.Controllers;


import com.example.demo.Services.SearchService;
import com.example.demo.dto.SearchServiceDTO;
import com.example.demo.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {


    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/search")
    public Page<Product> search(@RequestBody SearchServiceDTO searchServiceDTO){
        return searchService.search(searchServiceDTO.getQuery(),
                searchServiceDTO.getPageNumber(),
                searchServiceDTO.getPageSize());

    }

}
