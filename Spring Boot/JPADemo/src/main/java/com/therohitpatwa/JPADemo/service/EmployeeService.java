package com.therohitpatwa.JPADemo.service;


import com.therohitpatwa.JPADemo.entity.Employee;
import com.therohitpatwa.JPADemo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;



    public List<Employee>  getAllEmp()
    {
       List<Employee> listEmp= employeeRepo.findAll();
       return listEmp;
    }

    public Employee createEmp(Employee employee) {
        Employee emp=employeeRepo.save(employee);
        return emp;
    }
}
