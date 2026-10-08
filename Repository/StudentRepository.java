package com.project.studentManagementSystem.Repository;


import com.project.studentManagementSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByNameContainingIgnoreCase(String nameToFind);
}
