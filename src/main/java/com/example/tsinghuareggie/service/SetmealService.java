package com.example.tsinghuareggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.tsinghuareggie.dto.SetmealDto;
import com.example.tsinghuareggie.pojo.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {

    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
    void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时需要删除套餐和菜品的关联关系
     * @param
     */
    void removeWithDish(List<Long> ids);


    /**
     * 根据套餐id修改售卖状态
     * @param status
     * @param ids
     */
    void updateSetmealStatusById(Integer status, List<Long> ids);

    /**
     * 回显套餐数据：根据套餐id查询套餐
     * @return
     */
    SetmealDto getData(Long id);

}
