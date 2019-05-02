package com.lalith.student.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lalith.student.model.Student;
import com.lalith.student.model.StudentDTO;

import javassist.NotFoundException;

@Transactional
public interface StudentService {

	Student saveStudent(StudentDTO student);

	Student getStudentByName(String name);

	Student getStudentByRollNo(Long rollNo);

	Student updateStudentDetails(StudentDTO student) throws NotFoundException;

	Boolean deleteStudent(Long rollNo);

	List<Student> getAllStudents();

}
