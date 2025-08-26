package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreAPIRequestDTO {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
}
