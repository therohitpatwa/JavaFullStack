package com.example.WebDemo.repo;

import com.example.WebDemo.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    List<Student>  studentList=new ArrayList<>();
    public List<Student>   getAllStudent()
    {
        System.out.println("Repo Running");

        Student s1=new Student(1,"Rohit","LKO","C");
        Student s2=new Student(2,"Ajay","Delhi","Java");
        Student s3=new Student(3,"Raj","Bihar","C++");
        Student s4=new Student(4,"Feraz","Ranchi","PHP");
        Student s5=new Student(5,"Riyuuuuuuuuuuuu","LKO","C");

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);

        return studentList;

    }
    public void saveStudent(Student student)
    {
        studentList.add(student);
    }

    public void deleteStudent(int id)
    {
        for(Student student: studentList)
        {
            if(student.getId()==id)
            {
                studentList.remove(student);
                System.out.println("Student deleted");
                break;
            }
        }
    }



}
