package com.example.WebDemo.controller;


import com.example.WebDemo.dto.Student;
import com.example.WebDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;
    @GetMapping("/getAll")       //TO SHOW IT IS API
    public List<Student>   getAllStudent()
    {
          System.out.println("Controller Running");
          return service.getAllStudent();
    }


    @PostMapping("/save")
    public Student insertData(@RequestBody Student student)
    {
        System.out.println(student);//Browser can not post student where postman came into picture
        service.saveStudent(student);
        return student;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id)
    {
        System.out.println("Student id "+ id);
        service.deleteStudent(id);
    }



}
