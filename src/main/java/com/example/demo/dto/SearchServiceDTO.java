package com.example.demo.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchServiceDTO {
    private String query;
    private int pageSize;
    private int pageNumber;


}
