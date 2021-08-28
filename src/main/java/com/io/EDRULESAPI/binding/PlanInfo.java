package com.io.EDRULESAPI.binding;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PlanInfo {
    private String planName;
    private String planStatus;
    private String planStartDate;
    private String planEndDate;
    private String benefitAmt;
    private String denialReason;
}
