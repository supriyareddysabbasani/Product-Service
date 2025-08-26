package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateFrontendRequestDTO {
    private Long id;
    private String description;
    private String title;
    private String price;
    private String imageURL;
    private String category;
}
