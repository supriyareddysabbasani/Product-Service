package com.example.demo.dto;

import com.example.demo.models.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateFrontendRequestDTO {
    private String description;
    private String title;
    private String price;
    private String imageURL;
    private String category;

}
