package com.example.WebDemo.service;

import com.example.WebDemo.dto.Student;
import com.example.WebDemo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public List<Student>   getAllStudent()
    {
        System.out.println("Service Running");
         List<Student> allStudent=studentRepo.getAllStudent();
         return allStudent;
    }
    public void saveStudent(Student student)
    {
        studentRepo.saveStudent(student);
    }
    public void deleteStudent(int id)
    {
        studentRepo.deleteStudent(id);
    }



}
