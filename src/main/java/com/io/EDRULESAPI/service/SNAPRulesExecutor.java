package com.io.EDRULESAPI.service;

import com.io.EDRULESAPI.binding.IndInfo;
import com.io.EDRULESAPI.binding.PlanInfo;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.drools.core.rule.Package;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


@Service
public class SNAPRulesExecutor implements IRuleService{

    @Override
    public PlanInfo executeRules(IndInfo indInfo) {
        PlanInfo planInfo=null;
        try {
            InputStream is = getClass().getResourceAsStream("/com/ed/rules/SNAP.drl");
            Reader rd= new InputStreamReader(is);

            PackageBuilder  pkgBld = new PackageBuilder();
            pkgBld.addPackageFromDrl(rd);

            Package rulesPackage = pkgBld.getPackage();

            RuleBase ruleBase = RuleBaseFactory.newRuleBase();
            ruleBase.addPackage(rulesPackage);

            WorkingMemory workingMemory = ruleBase.newStatefulSession();
            workingMemory.insert(indInfo);
            workingMemory.fireAllRules();
            planInfo = indInfo.getPlanInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return planInfo;
    }
}
