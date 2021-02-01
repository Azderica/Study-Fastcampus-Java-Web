package com.myepark.eatgo.application;

import com.myepark.eatgo.domain.Region;
import com.myepark.eatgo.domain.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getRegions() {
        List<Region> regions = regionRepository.findAll();

//        List<Region> regions = new ArrayList<>();
//        regions.add(Region.builder().name("Seoul").build());

        return regions;
    }
}
