package com.myepark.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // ==table
// table이름이 같으므로 따로 선언의 필요가 없음.
public class User {
    // 이름이 동일하므로 Column을 넣을 필요가 없음
    // Jpa의 Entity 및 column은 자동으로 camel case -> DB의 snake case로 맞춰줍니다.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql이므로
    private Long id;

    private String account;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // 1 : N
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderDetail> orderDetailList;
}
