package com.io.EDRULESAPI.service;

import com.io.EDRULESAPI.binding.IndInfo;
import com.io.EDRULESAPI.binding.PlanInfo;

public interface IRuleService {
    public PlanInfo executeRules(IndInfo indInfo);
}
