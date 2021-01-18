package com.myepark.study.controller.api;

import com.myepark.study.ifs.CrudInterface;
import com.myepark.study.model.network.Header;
import com.myepark.study.model.network.request.PartnerApiRequest;
import com.myepark.study.model.network.response.PartnerApiResponse;
import com.myepark.study.service.PartnerApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/partner")
public class PartnerApiController implements CrudInterface<PartnerApiRequest, PartnerApiResponse> {

    @Autowired
    private PartnerApiLogicService partnerApiLogicService;

    @Override
    @PostMapping("")    // /api/item
    public Header<PartnerApiResponse> create(@RequestBody Header<PartnerApiRequest> request) {
        return partnerApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") // /api/item/1 ... 1000
    public Header<PartnerApiResponse> read(@PathVariable Long id) {
        return partnerApiLogicService.read(id);
    }

    @Override
    @PutMapping("")     // /api/item
    public Header<PartnerApiResponse> update(@RequestBody Header<PartnerApiRequest> request) {
        return partnerApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")  // /api/item/1 ... 1000
    public Header delete(@PathVariable Long id) {
        return partnerApiLogicService.delete(id);
    }
}
