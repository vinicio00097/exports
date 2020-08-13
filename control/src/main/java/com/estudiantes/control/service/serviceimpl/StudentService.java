package com.estudiantes.control.service.serviceimpl;

import com.estudiantes.control.dao.IStudentDAO;
import com.estudiantes.control.model.Student;
import com.estudiantes.control.services.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudent {

    @Autowired
    private IStudentDAO studentDAO;

    @Override
    public Student add(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public Student update(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public void delete(String id) {
        studentDAO.deleteById(id);
    }

    @Override
    public Optional<Student> find(String id) {
        return studentDAO.findById(id);
    }

    @Override
    public List<Student> getAll() {
        //studentDAO.findAll()

        return studentDAO.getAllByLimit();
    }

}
