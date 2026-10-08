package com.project.studentManagementSystem.DTO.StudentDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDTO {

    private String name;
    private String course;
    private Integer age;
    private LocalDateTime createdAt;

}
