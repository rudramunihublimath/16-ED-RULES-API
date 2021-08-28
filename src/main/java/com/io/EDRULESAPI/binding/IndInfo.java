package com.io.EDRULESAPI.binding;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class IndInfo {
    private String invFName;
    private String invLName;
    private String invDob;
    private String PlanName;
    private String isEmployed;

    private PlanInfo planInfo;

}
