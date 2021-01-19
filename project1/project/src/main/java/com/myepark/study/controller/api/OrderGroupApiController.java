package com.myepark.study.controller.api;

import com.myepark.study.controller.CrudController;
import com.myepark.study.model.network.request.OrderGroupApiRequest;
import com.myepark.study.model.network.response.OrderGroupApiResponse;
import com.myepark.study.service.OrderGroupApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = orderGroupApiLogicService;
    }
}
