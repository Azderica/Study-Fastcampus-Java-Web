package com.myepark.eatgo.interfaces;

import com.myepark.eatgo.application.RestaurantService;
import com.myepark.eatgo.domain.Restaurant;
import com.myepark.eatgo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = new ArrayList<>();

        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");

        restaurants.add(restaurant);

        return restaurants;
    }

    @GetMapping("/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        return null;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create() throws URISyntaxException {
        URI location = new URI("/resturants/1234");
        return ResponseEntity.created(location).body("{}");
    }
}
