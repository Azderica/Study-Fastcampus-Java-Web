package com.myepark.eatgo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Builder
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private  Long restaurantId;

    private String name;

    @NotNull
    private Integer score;

    @NotEmpty
    private String description;
}
