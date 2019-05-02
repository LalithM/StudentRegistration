package com.lalith.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lalith.student.model.Student;
import com.lalith.student.model.StudentDTO;
import com.lalith.student.service.StudentService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/")
	public ResponseEntity<Student> createStudent(@RequestBody @Valid StudentDTO student) {
		return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.ACCEPTED);
	}

	@GetMapping("/roll/{rollNo}")
	public ResponseEntity<Student> getStudent(@PathVariable("rollNo") Long rollNo) {
		return new ResponseEntity<>(studentService.getStudentByRollNo(rollNo), HttpStatus.OK);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Student> getStudent(@PathVariable("name") String name) {
		return new ResponseEntity<>(studentService.getStudentByName(name), HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Student>> getStudent() {
		return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<Student> updateStudent(@RequestBody @Valid StudentDTO student) throws NotFoundException {
		return new ResponseEntity<>(studentService.updateStudentDetails(student), HttpStatus.ACCEPTED);
	}

	@GetMapping("/del/{rollNo}")
	public ResponseEntity<Boolean> deleteStudent(@PathVariable("rollNo") Long rollNo) {
		return new ResponseEntity<>(studentService.deleteStudent(rollNo), HttpStatus.OK);
	}
}
