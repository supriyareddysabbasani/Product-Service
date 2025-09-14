package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.UpdateTimestamp;

@Setter
@Getter
public class FroentEndResponceDTO {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
    public String createTimeStamp;
    public String updateTimeStamp;
    public boolean isDelete;

}
