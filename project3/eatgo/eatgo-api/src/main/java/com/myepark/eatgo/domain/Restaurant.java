package com.myepark.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter @Setter
@Entity
@Builder
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

//    @NotNull
    private Long categoryId;

//    @NotEmpty
    private String name;

//    @NotEmpty
    private String address;


    public Restaurant(Long id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Restaurant(String name, String address){
        this.name = name;
        this.address = address;
    }

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MenuItem> menuItems;
//
//    @Transient
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private List<Review> reviews;
//
//    public String getInformation() {
//        return name + " in " + address;
//    }
//
//    public void updateInformation(Long categoryId,
//                                  String name, String address) {
//        this.categoryId = categoryId;
//        this.name = name;
//        this.address = address;
//    }
//
//    public void setMenuItems(List<MenuItem> menuItems) {
//        this.menuItems = new ArrayList<>(menuItems);
//    }
//
//    public void setReviews(List<Review> reviews) {
//        this.reviews = new ArrayList<>(reviews);
//    }
}
