package com.example.tsinghuareggie.dto;

import com.example.tsinghuareggie.pojo.Dish;
import com.example.tsinghuareggie.pojo.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;

}
