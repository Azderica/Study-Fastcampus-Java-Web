package com.myepark.eatgo.application;

import com.myepark.eatgo.domain.MenuItem;
import com.myepark.eatgo.domain.Restaurant;
import com.myepark.eatgo.repository.MenuItemRepository;
import com.myepark.eatgo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;
    private MenuItemRepository menuItemRepository;
//    private ReviewRepository reviewRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository,
                             MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        return restaurants;
    }

    public List<Restaurant> getRestaurants(String region, long categoryId) {
        List<Restaurant> restaurants =
                restaurantRepository.findAllByAddressContainingAndCategoryId(
                        region, categoryId);

        return restaurants;
    }

    public Restaurant getRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);

        return restaurant;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        Restaurant saved = restaurantRepository.save(restaurant);
        return saved;
    }
//
//    public Restaurant updateRestaurant(Long id, Long categoryId,
//                                       String name, String address) {
//        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
//
//        return restaurant;
//    }

}
