package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@Entity
@ToString
public class Category extends BaseModel {
    private String name;
    @OneToMany(mappedBy ="category")
    @JsonIgnore
    private List<Product> products;
}
