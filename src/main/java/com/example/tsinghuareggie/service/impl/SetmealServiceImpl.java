package com.example.tsinghuareggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tsinghuareggie.mapper.SetmealMapper;
import com.example.tsinghuareggie.pojo.Setmeal;
import com.example.tsinghuareggie.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}
