package com.therohitpatwa.JPADemo.controller;


import com.therohitpatwa.JPADemo.entity.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    public List<Employee> getAllEmployee()
    {

    }


}
