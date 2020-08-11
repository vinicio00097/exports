package com.estudiantes.control.dao;

import com.estudiantes.control.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentDAO extends JpaRepository<Student,String> {
}
