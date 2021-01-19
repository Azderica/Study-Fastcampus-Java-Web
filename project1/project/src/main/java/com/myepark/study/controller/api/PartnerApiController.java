package com.myepark.study.controller.api;

import com.myepark.study.controller.CrudController;
import com.myepark.study.model.network.request.PartnerApiRequest;
import com.myepark.study.model.network.response.PartnerApiResponse;
import com.myepark.study.service.PartnerApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse> {

    @Autowired
    private PartnerApiLogicService partnerApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = partnerApiLogicService;
    }
}
