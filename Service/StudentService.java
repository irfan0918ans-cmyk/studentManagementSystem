package com.project.studentManagementSystem.Service;

import com.project.studentManagementSystem.DTO.StudentDTO.StudentRequestDTO;
import com.project.studentManagementSystem.DTO.StudentDTO.StudentResponseDTO;
import com.project.studentManagementSystem.Entity.Student;
import com.project.studentManagementSystem.Exception.StudentNotFoundException;
import com.project.studentManagementSystem.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    private StudentResponseDTO toResponseDto(Student student){
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        dto.setCourse(student.getCourse());
        dto.setCreatedAt(student.getCreatedAt());
        return dto;
    }

    public StudentResponseDTO saveStudentService(StudentRequestDTO studentRequestDTO) {
        Student saveToDB = new Student();
        saveToDB.setName(studentRequestDTO.getName());
        saveToDB.setAge(studentRequestDTO.getAge());
        saveToDB.setCourse(studentRequestDTO.getCourse());
        saveToDB.setCreatedAt(LocalDateTime.now());
        saveToDB.setUpdatedAt(LocalDateTime.now());

        studentRepository.save(saveToDB);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setName(saveToDB.getName());
        studentResponseDTO.setAge(saveToDB.getAge());
        studentResponseDTO.setCourse(saveToDB.getCourse());
        studentResponseDTO.setCreatedAt(saveToDB.getCreatedAt());

        return studentResponseDTO;
    }

    public List<StudentResponseDTO> getAllStudentService(){
       return studentRepository.findAll()
               .stream()
               .map(student -> toResponseDto(student))
               .toList();
    }

    public StudentResponseDTO getStudentByNameService(String nameToFind){
        Student student = studentRepository.findByNameContainingIgnoreCase(nameToFind)
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
        return toResponseDto(student);
    }

    public StudentResponseDTO updateStudentService(String nameToUpdate, StudentRequestDTO studentRequestDTO){
        Student student = studentRepository.findByNameContainingIgnoreCase(nameToUpdate)
                .orElseThrow(() -> new StudentNotFoundException("Student not Found"));

        student.setName(studentRequestDTO.getName());
        student.setAge(studentRequestDTO.getAge());
        student.setCourse(studentRequestDTO.getCourse());
        student.setUpdatedAt(LocalDateTime.now());

        Student updatedStudent = studentRepository.save(student);

        return toResponseDto(updatedStudent);
    }

    public void deletedStudentService(String nameToDelete){
        Student student = studentRepository.findByNameContainingIgnoreCase(nameToDelete).
                orElseThrow(()-> new StudentNotFoundException("Student Not Found"));
        studentRepository.deleteById(student.getId());
    }
}
