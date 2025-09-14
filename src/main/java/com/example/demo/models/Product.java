package com.example.demo.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@Entity
@ToString
public class Product extends BaseModel implements Serializable {
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

    public void setCreateTimeStamp(String createTimeStamp){
        this.createTimeStamp = createTimeStamp;

    }

    public String getCreateTimeStamp(){
        return createTimeStamp;
    }

    public void setUpdateTimeStamp(String UpdateTimeStamp){
        this.updateTimeStamp = UpdateTimeStamp;

    }

    public String getUpdateTimeStamp(){
        return createTimeStamp;
    }

    public void setIsDelete(boolean isDelete){
        this.isDelete = isDelete;

    }

    public boolean getIsDelete(){
        return isDelete;
    }

}
