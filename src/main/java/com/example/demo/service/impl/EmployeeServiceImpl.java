package com.example.demo.service.impl;

import com.example.demo.bean.Employee;
import com.example.demo.dao.EmployeeMapper;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qianduoduo
 * @date 2019/2/14  14:09
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee selectLibrarian(int id) {
        // TODO Auto-generated method stub
        return employeeMapper.selectEmployee(id);
    }
}
