package com.project.studentManagementSystem.Controller;


import com.project.studentManagementSystem.DTO.StudentDTO.StudentRequestDTO;
import com.project.studentManagementSystem.DTO.StudentDTO.StudentResponseDTO;
import com.project.studentManagementSystem.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentServiceImp){
        this.studentService = studentServiceImp;
    }

    @PostMapping("/save")
    public ResponseEntity<StudentResponseDTO> saveStudentController(@RequestBody StudentRequestDTO studentRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.saveStudentService(studentRequestDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudentController(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.getAllStudentService());
    }

    @PutMapping("/update")
    public ResponseEntity<StudentResponseDTO> updateStudentController(@RequestParam String nameToUpdate,
                                                                      @RequestBody StudentRequestDTO studentRequestDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.updateStudentService(nameToUpdate,studentRequestDTO));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudentController(@RequestParam String nameToDelete){
        studentService.deletedStudentService(nameToDelete);
       return ResponseEntity.status(HttpStatus.OK)
                .body("Student Deleted Successfully");
    }

}
