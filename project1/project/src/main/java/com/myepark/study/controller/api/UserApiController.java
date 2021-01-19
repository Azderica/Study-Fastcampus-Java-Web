package com.myepark.study.controller.api;

import com.myepark.study.controller.CrudController;
import com.myepark.study.model.network.request.UserApiRequest;
import com.myepark.study.model.network.response.UserApiResponse;
import com.myepark.study.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = userApiLogicService;
    }
}
