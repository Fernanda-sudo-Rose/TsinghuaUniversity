package com.example.tsinghuareggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tsinghuareggie.mapper.DishFlavorMapper;
import com.example.tsinghuareggie.pojo.DishFlavor;
import com.example.tsinghuareggie.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
