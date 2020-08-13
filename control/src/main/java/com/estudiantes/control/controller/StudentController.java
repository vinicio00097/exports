package com.estudiantes.control.controller;

import com.estudiantes.control.model.Student;
import com.estudiantes.control.service.serviceimpl.StudentService;
import com.estudiantes.control.utils.ConverterTypes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

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

    @PostMapping(value = "/exportar")
    public void getExport(@RequestParam String headers,@RequestParam String type, HttpServletResponse response){
        String[] headers_array=headers.split(",");

        switch (type){
            case "json":
                ConverterTypes.toJson(response,headers_array,studentService);
                break;
            case "csv":
                ConverterTypes.toCsv(response,headers_array,studentService);
                break;
            case "xml":
                ConverterTypes.toXml(response,headers_array,studentService);
                break;
        }
    }
}
