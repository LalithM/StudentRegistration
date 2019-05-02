package com.lalith.student.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class StudentDTO {

	private Long rollNo;

	@NotNull(message = "Name field cannot be null")
	@Size(min = 3, message = "year must not be more than 2 characters")
	private String name;

	private Integer age;

	private Gender gender;

	private Integer year;

	public enum Gender {
		MALE("M"), FEMALE("F");

		String gender;

		Gender(String gender) {
			this.gender = gender;
		}

		public String getGender() {
			return this.gender;
		}
	}
}
