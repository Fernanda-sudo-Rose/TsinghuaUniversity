package com.example.tsinghuareggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tsinghuareggie.common.CustomException;
import com.example.tsinghuareggie.mapper.CategoryMapper;
import com.example.tsinghuareggie.pojo.Category;
import com.example.tsinghuareggie.pojo.Dish;
import com.example.tsinghuareggie.pojo.Setmeal;
import com.example.tsinghuareggie.service.CategoryService;
import com.example.tsinghuareggie.service.DishService;
import com.example.tsinghuareggie.service.SetmealService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Resource
    private DishService dishService;

    @Resource
    private SetmealService setmealService;

    /**
     *
     * @param id
     */
    @Override
    public void remove(Long id) {

        // 查询菜品分类
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 添加查询条件
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        // 注意:这里使用count方法的时候一定要传入条件查询的对象，否则计数会出现问题，计算出来的是全部的数据的条数
        int dishCount = dishService.count(dishLambdaQueryWrapper);
        // 查询当前菜品分类是否关联了菜品，如果已经管理，直接抛出一个业务异常
        if (dishCount > 0) {
            // 已经关联了菜品，抛出一个业务异常
            throw new CustomException("当前分类项关联了菜品,不可以删除");
        }

        // 查询套餐分类
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 添加查询条件
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        // 注意:这里使用count方法的时候一定要传入条件查询的对象，否则计数会出现问题，计算出来的是全部的数据的条数
        int setmealCount = setmealService.count(setmealLambdaQueryWrapper);
        // 查询当前套餐分类是否已经关联菜品，如果已经管理，则直接抛出异常
        if (setmealCount > 0) {
            // 已经关联菜品，抛出一个异常
            throw new CustomException("当前分类项关联了套餐,不可以删除");
        }

        // 没有关联菜品，正常删除
        super.removeById(id);
    }
}
