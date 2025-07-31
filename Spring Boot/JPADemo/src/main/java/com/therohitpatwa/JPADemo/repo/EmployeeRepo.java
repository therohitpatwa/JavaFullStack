package com.therohitpatwa.JPADemo.repo;

import com.therohitpatwa.JPADemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
