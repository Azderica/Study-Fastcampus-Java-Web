package com.myepark.project.controller.dto;


import com.myepark.project.domain.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class GroupDto {
    private String description;
    private List<Person> personList;
}
