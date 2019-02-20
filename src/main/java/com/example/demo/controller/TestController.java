package com.example.demo.controller;

import com.example.demo.bean.Employee;
import com.example.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qianduoduo
 * @date 2019/2/1  11:08
 */
@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/getLibrarian")
    public Employee getALibrarianInfo(@RequestParam int id, HttpServletRequest httpServletRequest){
        String id1 = httpServletRequest.getParameter("id");
        System.out.printf("------>"+id1);
        //System.out.println("test :id: "+id);
        return employeeService.selectLibrarian(id);

    }
    @GetMapping(value = "/test")
    public String test(){
        return "ok";
    }


}
