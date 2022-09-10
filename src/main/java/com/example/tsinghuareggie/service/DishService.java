package com.example.tsinghuareggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.tsinghuareggie.dto.DishDto;
import com.example.tsinghuareggie.pojo.Dish;

import java.util.List;

public interface DishService extends IService<Dish> {

    /**
     * 新增菜品,同时插入菜品对应的口味数据,
     * 需要同时操作两张表: dish  dish_flavor
     * @param dishDto
     */
    void saveWithFlavor(DishDto dishDto);

    /**
     * 根据id来查询菜品信息和对应的口味信息
     * @param id
     */
    DishDto getByIdWithFlavor(Long id);

    /**
     * 更新菜品信息同时还更新对应的口味信息
     * @param dishDto
     */
    void updateWithFlavor(DishDto dishDto);

    /**
     * 根据传过来的id批量或者是单个的删除菜品
     * @param ids
     */
    void deleteByIds(List<Long> ids);
}
