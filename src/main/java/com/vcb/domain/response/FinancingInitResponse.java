package com.vcb.domain.response;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * Created by fangxm on 19-1-25.
 */
@Data
public class FinancingInitResponse{
    private String financingSn;
    private String financingName;
    private String varietyCode;
    private Integer status;
    private BigDecimal financingTotal;
    private BigDecimal financingFact;
    private Integer financingDay;
    private BigDecimal financingAnnualInterestPercent;
    private BigDecimal investMin;
    private BigDecimal investMax;
    private Date startDate;
    private Date endDate;
    private BigDecimal available;
}
