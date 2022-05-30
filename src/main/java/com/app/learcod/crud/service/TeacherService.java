package com.app.learcod.crud.service;

import com.app.learcod.crud.controller.dto.TeacherDTO;
import com.app.learcod.crud.model.Teacher;
import com.app.learcod.crud.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("TeacherService")
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    Teacher teacher;

    public List<Teacher> listTeacher() {
        try {
            return teacherRepository.findAll();
        } catch(Exception e) {
            throw e;
        }
    }

    public Teacher saveTeacher(TeacherDTO teacherDTO){
        try {
            Teacher teacher = teacherDTO.toConverterTeacherDTO();
            boolean existTeacherSave = checkIfTeacherSave(teacher.getId());
            if (!existTeacherSave) {
                return teacherRepository.save(teacher);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean removeTeacher(Long id) {
        try {
            boolean existTeacherSave = this.checkIfTeacherSave(id);
            if (existTeacherSave) {
                teacherRepository.deleteById(this.teacher.getId());
                return true;
            } else {
                return false;
            }
        } catch(Exception e) {
            throw e;
        }
    }

    public Teacher updateTeacher(Long id, TeacherDTO teacherDTO) {
        try {
            Teacher teacher = teacherDTO.toConverterTeacherDTO();
            boolean existTeacherSave = this.checkIfTeacherSave(id);
            if (existTeacherSave) {
                this.teacher.setSiape(teacher.getSiape());
                return teacherRepository.save(this.teacher);
            } else {
                return null;
            }
        } catch(Exception e) {
            throw e;
        }
    }

    public boolean checkIfTeacherSave(Long id) {
        this.teacher = teacherRepository.findBySiape(id);
        if (Objects.isNull(this.teacher)) {
            return false;
        } else {
            return true;
        }
    }

}
