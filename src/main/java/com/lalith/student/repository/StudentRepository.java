package com.lalith.student.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.lalith.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findByName(String name);

	Optional<Student> findByRollNo(Long rollNo);

	@Transactional
	@Modifying
	@Query("update Student set isActive=false where rollNo=?1")
	void deleteStudentDetails(Long rollNo);

	List<Student> findAllByIsActive(Boolean isActive);

}
