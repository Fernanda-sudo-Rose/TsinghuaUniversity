package com.example.tsinghuareggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.tsinghuareggie.common.R;
import com.example.tsinghuareggie.pojo.Category;
import com.example.tsinghuareggie.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 新增分类
     * @param category
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody Category category) {

        log.info(category.toString());
        categoryService.save(category);

        return R.success("新增分类成功");
    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize) {

        //创建一个分页构造器
        Page<Category> categoryPage = new Page<>(page, pageSize);

        //创建一个条件构造器  用来排序用的  注意这个条件构造器一定要使用泛型，否则使用条件查询这个方法的时候会报错
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();

        //添加排序条件 ，根据sort字段进行排序
        queryWrapper.orderByDesc(Category::getSort);

        categoryService.page(categoryPage, queryWrapper);
        return R.success(categoryPage);
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @DeleteMapping
    public R<String> delById(@RequestParam("id") Long id) { // 注意这里前端传过来的数据是ids

        log.info("删除分类，id为：{}", id);

        //categoryService.removeById(id);
        categoryService.remove(id);

        return R.success("分类信息删除成功");
    }

    /**
     * 根据id修改分类信息
     * @param category
     * @return
     */
    @PutMapping
    public R<String> updateById(@RequestBody Category category) {

        log.info("根据id修改分类信息：{}", category);
        categoryService.updateById(category);

        return R.success("修改分类信息成功");

    }

}
