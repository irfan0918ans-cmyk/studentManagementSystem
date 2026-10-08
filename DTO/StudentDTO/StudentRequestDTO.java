package com.project.studentManagementSystem.DTO.StudentDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {

    private String name;
    private Integer age;
    private String course;

}
