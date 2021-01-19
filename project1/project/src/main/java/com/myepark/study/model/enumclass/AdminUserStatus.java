package com.myepark.study.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AdminUserStatus {

    REGISTERED(0, "등록", "어드민사용자 등록상태"),
    UNREGISTERED(1, "해지", "어드민사용자 해지상태")
    ;

    private Integer id;
    private String title;
    private String description;

}
