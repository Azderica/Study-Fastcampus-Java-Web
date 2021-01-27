package com.myepark.eatgo.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter @Setter
public class Restaurant {

    private Long id;
    private String name;
    private String address;

}
