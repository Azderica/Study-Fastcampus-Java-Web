package com.myepark.study.controller.api;

import com.myepark.study.ifs.CrudInterface;
import com.myepark.study.model.network.Header;
import com.myepark.study.model.network.request.OrderDetailApiRequest;
import com.myepark.study.model.network.response.OrderDetailApiResponse;
import com.myepark.study.service.OrderDetailApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailApiController implements CrudInterface<OrderDetailApiRequest, OrderDetailApiResponse> {

    @Autowired
    private OrderDetailApiLogicService orderDetailApiLogicService;

    @Override
    @PostMapping("")
    public Header<OrderDetailApiResponse> create(@RequestBody Header<OrderDetailApiRequest> request) {
        return orderDetailApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<OrderDetailApiResponse> read(@PathVariable Long id) {
        return orderDetailApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<OrderDetailApiResponse> update(@RequestBody Header<OrderDetailApiRequest> request) {
        return orderDetailApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return orderDetailApiLogicService.delete(id);
    }
}
