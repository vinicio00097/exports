package com.estudiantes.control.controller;

import com.estudiantes.control.model.Student;
import com.estudiantes.control.service.serviceimpl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiantes")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("")
    public String index(Model model){
        /*retornar estudiantes*/
        model.addAttribute("students",studentService.getAll());

        return "student";
    }

    @PostMapping("/nuevo")
    public String addStudent(@RequestBody Student student, Model model){
        studentService.add(student);

        return "your_Action";
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteStudent(@RequestParam String id){
        studentService.delete(id);
        return "your_Action";
    }

    @PutMapping("/{id}")
    public String updateStudent(@RequestParam String id, @RequestBody Student student){
        studentService.update(student);

        return "your_Action";
    }
}
