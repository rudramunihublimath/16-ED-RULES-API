package com.io.EDRULESAPI.controller;

import com.io.EDRULESAPI.binding.IndInfo;
import com.io.EDRULESAPI.binding.PlanInfo;
import com.io.EDRULESAPI.service.DetermineEligService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetermineEligRestController {

    @Autowired
    private DetermineEligService eligService;

    @PostMapping(
            value = "/rules",
            produces = {"application/xml","application/json"},
            consumes = {"application/xml","application/json"}
    )
    public PlanInfo checkElig(@RequestBody IndInfo indInfo){
        PlanInfo planInfo = eligService.determineEligibility(indInfo);
        return planInfo;
    }



}
