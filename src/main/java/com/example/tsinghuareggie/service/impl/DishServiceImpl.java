package com.example.tsinghuareggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tsinghuareggie.mapper.DishMapper;
import com.example.tsinghuareggie.pojo.Dish;
import com.example.tsinghuareggie.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {

}
