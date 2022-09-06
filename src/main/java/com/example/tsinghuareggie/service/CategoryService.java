package com.example.tsinghuareggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.tsinghuareggie.pojo.Category;

public interface CategoryService extends IService<Category> {
    void remove(Long id);
}
