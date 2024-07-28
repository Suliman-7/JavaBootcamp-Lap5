package com.example.student.Controller;

import com.example.student.Api.ApiResponse;
import com.example.student.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")

public class studentController {

    ArrayList<Student> students = new ArrayList<>();

    @GetMapping("/students")
    public ArrayList<Student> getStudents() {
        return students;
    }

    @PostMapping("/post")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("student added successfully !", "200");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@PathVariable int index, @RequestBody Student student) {
        students.set(index, student);
        return new ApiResponse("student updated successfully !", "200");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index) {
        students.remove(index);
        return new ApiResponse("student deleted successfully !", "200");
    }


    @GetMapping("/name/{index}")
    public String getName(@PathVariable int index) {

        return students.get(index).getName();
    }


    @GetMapping("/age/{index}")
    public int getAge(@PathVariable int index) {
        return students.get(index).getAge();
    }

    @GetMapping("/collegedegree/{index}")
    public String getCollegeDegree(@PathVariable int index) {
        return students.get(index).getCollegeDegree();
    }

    @GetMapping("studystatus/{index}")
    public boolean getStudentStatus(@PathVariable int index) {
        return students.get(index).getStudyStatus().equalsIgnoreCase("graduated");
    }




}





