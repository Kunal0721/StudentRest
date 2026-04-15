package com.crud.CrudStudent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.CrudStudent.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
