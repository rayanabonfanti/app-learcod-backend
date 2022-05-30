package com.app.learcod.crud.repository;

import com.app.learcod.crud.model.Student;
import com.app.learcod.crud.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findBySiape(Long id);
}
