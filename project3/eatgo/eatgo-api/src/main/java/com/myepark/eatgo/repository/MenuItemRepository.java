package com.myepark.eatgo.repository;

import com.myepark.eatgo.domain.MenuItem;

import java.util.List;

public interface MenuItemRepository {
    List<MenuItem> findAllByRestaurantId(Long id);
}
