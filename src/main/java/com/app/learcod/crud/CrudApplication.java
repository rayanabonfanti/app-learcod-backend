package com.app.learcod.crud;

import com.app.learcod.crud.model.Student;
import com.app.learcod.crud.model.Teacher;
import com.app.learcod.crud.model.User;
import com.app.learcod.crud.repository.StudentRepository;
import com.app.learcod.crud.repository.TeacherRepository;
import com.app.learcod.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	TeacherRepository teacherRepository;
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User userStudent = new User("Alice Almeida","alicealmeira@ifba.edu.br");
		User userTeacher = new User("Rayana Ribeiro","rayanaribeiro@ufsb.edu.br");
		Student student = new Student(2017125013L, userStudent);
		Teacher teacher = new Teacher(5656576453L, userTeacher);
		userRepository.saveAll(Arrays.asList(userStudent));
		userRepository.saveAll(Arrays.asList(userTeacher));
		studentRepository.saveAll(Arrays.asList(student));
		teacherRepository.saveAll(Arrays.asList(teacher));
	}
}
