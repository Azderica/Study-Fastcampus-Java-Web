package com.myepark.study.controller.api;

import com.myepark.study.controller.CrudController;
import com.myepark.study.model.network.request.OrderDetailApiRequest;
import com.myepark.study.model.network.response.OrderDetailApiResponse;
import com.myepark.study.service.OrderDetailApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailApiController extends CrudController<OrderDetailApiRequest, OrderDetailApiResponse> {

    @Autowired
    private OrderDetailApiLogicService orderDetailApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = orderDetailApiLogicService;
    }
}
