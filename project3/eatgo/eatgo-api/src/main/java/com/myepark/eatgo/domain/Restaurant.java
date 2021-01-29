package com.myepark.eatgo.domain;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter @Setter
public class Restaurant {
    private Long id;
    private String name;
    private String address;
    private List<MenuItem> menuItems;

    public Restaurant(Long id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
