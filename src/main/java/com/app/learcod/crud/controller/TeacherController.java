package com.app.learcod.crud.controller;

import com.app.learcod.crud.controller.dto.TeacherDTO;
import com.app.learcod.crud.model.Teacher;
import com.app.learcod.crud.repository.TeacherRepository;
import com.app.learcod.crud.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/teacher/")
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    private TeacherService teacherService;

    @GetMapping()
    public ResponseEntity<?> list() {
        try {
            List<Teacher> listTeachers = teacherService.listTeacher();
            if (!listTeachers.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(listTeachers);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody TeacherDTO teacherDTO) {
        try {
            Teacher teacherSave = teacherService.saveTeacher(teacherDTO);
            if (!Objects.isNull(teacherSave)) {
                return ResponseEntity.status(HttpStatus.OK).body(teacherSave);
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
            boolean existTeacherSave = teacherService.checkIfTeacherSave(id);
            if (existTeacherSave) {
                return ResponseEntity.status(HttpStatus.OK).body(teacherService.removeTeacher(id));
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TeacherDTO teacherDTO) {
        try {
            Teacher teacherUpdate = teacherService.updateTeacher(id,teacherDTO);
            if (!Objects.isNull(teacherUpdate)) {
                return ResponseEntity.status(HttpStatus.OK).body(teacherUpdate);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
