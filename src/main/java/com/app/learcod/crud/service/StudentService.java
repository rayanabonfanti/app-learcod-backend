package com.app.learcod.crud.service;

import com.app.learcod.crud.controller.dto.StudentDTO;
import com.app.learcod.crud.model.Student;
import com.app.learcod.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("StudentService")
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    Student student;

    public List<Student> listStudent() {
        try {
            return studentRepository.findAll();
        } catch(Exception e) {
            throw e;
        }
    }

    public Student saveStudent(StudentDTO studentDTO){
        try {
            Student student = studentDTO.toConverterStudentDTO();
            boolean existStudentSave = checkIfStudentSave(student.getId());
            if (!existStudentSave) {
                return studentRepository.save(student);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean removeStudent(Long id) {
        try {
            boolean existStudentSave = this.checkIfStudentSave(id);
            if (existStudentSave) {
                studentRepository.deleteById(this.student.getId());
                return true;
            } else {
                return false;
            }
        } catch(Exception e) {
            throw e;
        }
    }

    public Student updateStudent(Long id, StudentDTO studentDTO) {
        try {
            Student student = studentDTO.toConverterStudentDTO();
            boolean existStudentSave = this.checkIfStudentSave(id);
            if (existStudentSave) {
                this.student.setRegistration(student.getRegistration());
                return studentRepository.save(this.student);
            } else {
                return null;
            }
        } catch(Exception e) {
            throw e;
        }
    }

    public boolean checkIfStudentSave(Long id) {
        this.student = studentRepository.findByRegistration(id);
        if (Objects.isNull(this.student)) {
            return false;
        } else {
            return true;
        }
    }

}
