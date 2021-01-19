package com.myepark.study.controller.api;

import com.myepark.study.controller.CrudController;
import com.myepark.study.model.network.request.AdminUserApiRequest;
import com.myepark.study.model.network.response.AdminUserApiResponse;
import com.myepark.study.service.AdminUserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController extends CrudController<AdminUserApiRequest, AdminUserApiResponse> {

    @Autowired
    private AdminUserApiLogicService adminUserApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = adminUserApiLogicService;
    }
}
