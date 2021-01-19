package com.myepark.study.controller.api;

import com.myepark.study.controller.CrudController;
import com.myepark.study.model.network.request.ItemApiRequest;
import com.myepark.study.model.network.response.ItemApiResponse;
import com.myepark.study.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = itemApiLogicService;
    }
}
