package com.myepark.eatgo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String email;

    @NotEmpty
    private String name;

    @NotNull
    private Long level;

    public boolean isAdmin() {
        if(level >= 100)
            return true;
        return false;
    }

}
