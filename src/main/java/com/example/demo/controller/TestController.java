package com.example.demo.controller;

import com.example.demo.bean.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qianduoduo
 * @date 2019/2/1  11:08
 */
@RestController
public class TestController {


    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/getLibrarian")
    public Employee getALibrarianInfo(int id) {
        //System.out.println("test :id: "+id);
        return employeeService.selectLibrarian(id);
    }
    @GetMapping(value = "/test")
    public String test(){
        return "ok";
    }


}
