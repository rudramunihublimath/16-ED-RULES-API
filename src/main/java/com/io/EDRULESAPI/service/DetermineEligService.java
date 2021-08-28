package com.io.EDRULESAPI.service;

import com.io.EDRULESAPI.binding.IndInfo;
import com.io.EDRULESAPI.binding.PlanInfo;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service("eligService")
public class DetermineEligService {

    public PlanInfo determineEligibility(IndInfo indInfo){
        String pName= indInfo.getPlanName();
        String clzName= "com.io.EDRULESAPI.service." + pName + "RulesExecutor";
        PlanInfo planInfo=null;
        try{
            Class<?> clz= Class.forName(clzName);
            Method method=clz.getDeclaredMethod("executeRules",IndInfo.class);
            Object obj= clz.newInstance();
            planInfo = (PlanInfo) method.invoke(obj,indInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planInfo;
    }
}
