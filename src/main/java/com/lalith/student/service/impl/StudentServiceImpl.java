package com.lalith.student.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lalith.student.model.Student;
import com.lalith.student.model.StudentDTO;
import com.lalith.student.repository.StudentRepository;
import com.lalith.student.service.StudentService;

import javassist.NotFoundException;

@Service
public class StudentServiceImpl implements StudentService {

	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student saveStudent(StudentDTO student) {
		logger.info("Inside StudentServiceImpl saveStudent start");
		if (Objects.nonNull(student)) {
			Student dbResponse = isPresent(student.getName());
			if (Objects.isNull(dbResponse)) {
				Student stud = new Student();
				stud.setAge(student.getAge());
				stud.setGender(student.getGender().getGender());
				stud.setName(student.getName());
				stud.setYear(student.getYear());
				stud.setCreatedDate(LocalDate.now());
				return studentRepository.save(stud);
			} else {
				return dbResponse;
			}
		} else {
			throw new IllegalArgumentException("Invalid parameters passed");
		}
	}

	@Override
	public Student getStudentByName(String name) {
		logger.info("Inside StudentServiceImpl getStudentByName start");
		Student student = isPresent(name);
		return Objects.nonNull(student) ? student : new Student();
	}

	@Override
	public Student getStudentByRollNo(Long rollNo) {
		logger.info("Inside StudentServiceImpl getStudentByRollNo start");
		Student student = isPresent(rollNo);
		return Objects.nonNull(student) ? student : new Student();
	}

	@Override
	public Student updateStudentDetails(StudentDTO student) throws NotFoundException {
		logger.info("Inside StudentServiceImpl updateStudentDetails start");
		Student stud = isPresent(student.getRollNo());
		if (Objects.nonNull(stud)) {
			stud.setAge(student.getAge());
			stud.setGender(student.getGender().getGender());
			stud.setName(student.getName());
			stud.setYear(student.getYear());
			stud.setUpdatedDate(LocalDate.now());
			stud.setRollNo(student.getRollNo());
			return studentRepository.save(stud);
		} else {
			throw new NotFoundException("No user found with given RollNo" + student.getRollNo());
		}
	}

	@Override
	public Boolean deleteStudent(Long rollNo) {
		logger.info("Inside StudentServiceImpl deleteStudent start");
		Student stud = isPresent(rollNo);
		if (Objects.nonNull(stud)) {
			studentRepository.deleteStudentDetails(rollNo);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;

	}
	
	@Override
	public List<Student> getAllStudents(){
		return	studentRepository.findAllByIsActive(Boolean.TRUE);
	}

	private Student isPresent(String name) {
		Optional<Student> response = studentRepository.findByName(name);
		if (response.isPresent()) {
			return response.get();
		}
		return null;
	}

	private Student isPresent(Long rollNo) {
		Optional<Student> response = studentRepository.findByRollNo(rollNo);
		if (response.isPresent()) {
			return response.get();
		}
		return null;
	}

}
