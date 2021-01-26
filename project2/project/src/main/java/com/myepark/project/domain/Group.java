package com.myepark.project.domain;

import com.myepark.project.controller.dto.GroupDto;
import lombok.*;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString(exclude = {"personList"})
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    // Group 1 : N Person
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private List<Person> personList;

    public void set(GroupDto groupDto) {
        if(!StringUtils.isEmpty(groupDto.getDescription())){
            this.setDescription(groupDto.getDescription());
        }

        if(groupDto.getPersonList() != null){
            this.setPersonList(groupDto.getPersonList());
        }
    }
}
