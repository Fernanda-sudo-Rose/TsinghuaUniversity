package com.example.tsinghuareggie.dto;

import com.example.tsinghuareggie.pojo.Setmeal;
import com.example.tsinghuareggie.pojo.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;

}
