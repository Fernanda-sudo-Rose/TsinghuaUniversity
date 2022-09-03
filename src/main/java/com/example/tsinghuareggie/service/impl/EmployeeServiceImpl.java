package com.example.tsinghuareggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.tsinghuareggie.mapper.EmployeeMapper;
import com.example.tsinghuareggie.pojo.Employee;
import com.example.tsinghuareggie.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
