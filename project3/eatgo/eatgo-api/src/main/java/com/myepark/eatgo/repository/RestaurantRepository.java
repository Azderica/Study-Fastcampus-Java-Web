package com.myepark.eatgo.repository;

import com.myepark.eatgo.domain.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    Restaurant findById(Long id);

    List<Restaurant> findAll();
}
