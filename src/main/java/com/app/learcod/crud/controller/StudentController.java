package com.app.learcod.crud.controller;

import com.app.learcod.crud.controller.dto.StudentDTO;
import com.app.learcod.crud.model.Student;
import com.app.learcod.crud.repository.StudentRepository;
import com.app.learcod.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public ResponseEntity<?> list() {
        try {
            List<Student> listStudents = studentService.listStudent();
            if (!listStudents.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(listStudents);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody StudentDTO studentDTO) {
        try {
            Student studentSave = studentService.saveStudent(studentDTO);
            if (!Objects.isNull(studentSave)) {
                return ResponseEntity.status(HttpStatus.OK).body(studentSave);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> remove(@PathVariable Long id) {
        try {
            boolean existStudentSave = studentService.checkIfStudentSave(id);
            if (existStudentSave) {
                return ResponseEntity.status(HttpStatus.OK).body(studentService.removeStudent(id));
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        try {
            Student studentUpdate = studentService.updateStudent(id,studentDTO);
            if (!Objects.isNull(studentUpdate)) {
                return ResponseEntity.status(HttpStatus.OK).body(studentUpdate);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
