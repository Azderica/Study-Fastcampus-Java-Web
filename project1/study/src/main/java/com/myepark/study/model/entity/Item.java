package com.myepark.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String title;

    private Integer price;

    private String content;

    // 1 : N
    // fetch Type
    // LAZY = 지연 로딩(필요없으면 안 가져옴), EAGER = 즉시 로딩 (join을 다해버림, 성능의 저하)

    // LAZY => select * from item where id = ?
    // EAGER => select * from item
    //  item_id = order_datail.item_id
    //  user_id = order_detail.user_id
    //  where item.id = ?
    // 일반적으로는 EAGER는 1:1인 경우만 사용하는 것이 중요. 대부분은 LAZY를 사용하기
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}
