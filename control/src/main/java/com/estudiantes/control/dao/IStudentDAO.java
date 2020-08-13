package com.estudiantes.control.dao;

import com.estudiantes.control.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface IStudentDAO extends JpaRepository<Student,String> {
    @Query(value = "select * from t2_student limit 10",nativeQuery = true)
    List<Student> getAllByLimit();
}
