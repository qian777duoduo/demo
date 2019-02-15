package com.example.demo.dao;

import com.example.demo.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author qianduoduo
 * @date 2019/2/15  10:24
 */
@Mapper
public interface EmployeeMapper {
    Employee selectEmployee(int id);
}
