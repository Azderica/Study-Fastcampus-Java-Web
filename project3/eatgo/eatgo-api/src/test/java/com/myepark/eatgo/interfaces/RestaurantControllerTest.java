package com.myepark.eatgo.interfaces;

import com.myepark.eatgo.application.RestaurantService;
import com.myepark.eatgo.domain.MenuItem;
import com.myepark.eatgo.domain.Restaurant;
import com.myepark.eatgo.repository.MenuItemRepository;
import com.myepark.eatgo.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
public class RestaurantControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private RestaurantService restaurantService;

    @MockBean
    private RestaurantRepository restaurantRepository;

    @MockBean
    private MenuItemRepository menuItemRepository;


    private MockMvc mockMvc;

    @BeforeEach
    void beforeEach() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .alwaysDo(print())
                .build();

        MockitoAnnotations.initMocks(this);
        mockRestaurantRepository();
        mockMenuItemRepository();

//        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);
    }

    private void mockRestaurantRepository() {
        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
        restaurants.add(restaurant);

//        given(restaurantService.findAll()).willReturn(restaurants);
//        given(restaurantService.findById(1004L)).willReturn(restaurant);
    }

    private void mockMenuItemRepository() {
        List<MenuItem> menuItems = new ArrayList<>();
//        menuItems.add(new MenuItem("Kimchi"));

//        given(menuItemRepository.findAllByRestaurantId(1004L)).willReturn(menuItemsa);
    }

    @Test
    public void list() throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L, "Bob zip", "Seould"));


    }

    @Test
    public void detail() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/restaurants/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void create() throws Exception {
        Restaurant restaurant = new Restaurant(1234L, "BeRyong", "Seoul");

        mockMvc.perform(post("/restaurants"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/restaurants/1234"))
                .andExpect(content().string("{}"));

//        verify(restaurantService).addRestaurant(restaurant);
    }
}