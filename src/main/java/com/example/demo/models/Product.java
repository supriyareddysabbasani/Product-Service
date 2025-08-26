package com.example.demo.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Product extends BaseModel {
//    private Long id;
    private String description;
    private String title;
    private double price;
    private String imageURL;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    public void setId(Long id){
        this.id = id;
    }
}
