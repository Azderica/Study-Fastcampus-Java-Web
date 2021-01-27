package com.myepark.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTest {

    @Test
    public void creation() {
        Restaurant restaurant = new Restaurant();
        //assertThat(restaurant.getName(), is("fail"));
    }
}