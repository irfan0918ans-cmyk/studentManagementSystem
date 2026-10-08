package com.project.studentManagementSystem.Controller;


import com.project.studentManagementSystem.DTO.StudentDTO.StudentRequestDTO;
import com.project.studentManagementSystem.DTO.StudentDTO.StudentResponseDTO;
import com.project.studentManagementSystem.Service.StudentService;
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
    public StudentResponseDTO saveStudentController(@RequestBody StudentRequestDTO studentRequestDTO){
        return studentService.saveStudentService(studentRequestDTO);
    }

    @GetMapping("/getAll")
    public List<StudentResponseDTO> getAllStudentController(){
        return studentService.getAllStudentService();
    }

    @PutMapping("/update")
    public StudentResponseDTO updateStudentController(@RequestParam String nameToUpdate,
                                                      @RequestBody StudentRequestDTO studentRequestDTO){
        return studentService.updateStudentService(nameToUpdate,studentRequestDTO);
    }

    @DeleteMapping("/delete")
    public String deleteStudentController(@RequestParam String nameToDelete){
        studentService.deletedStudentService(nameToDelete);
        return "Deleted Successfully";
    }

}
