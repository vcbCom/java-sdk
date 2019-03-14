package com.vcb.domain.response;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 活期理财列表
 */
@Getter
@Setter
public class SearchCurrentFinancingResponse {

    /**
     * 理财编号
     */
    private String currentFinancingSn;

    /**
     * 理财名称
     */
    private String currentFinancingName;

    /**
     * 币种编码
     */
    private String varietyCode;

    /**
     * 募集总量
     */
    private BigDecimal totalAmount;

    /**
     * 年化利率
     */
    private BigDecimal annualInterest;

    /**
     * 七日年化利率
     */
    private BigDecimal sevenAnnualInterest;

    /**
     * 万分利率
     */
    private BigDecimal interest;


    /**
     * 最小买入量
     */
    private BigDecimal investMin;

    /**
     * 最大买入量
     */
    private BigDecimal investMax;

    /**
     * 上线时间
     */
    private Date createTime;

    /**
     * 是否募满
     */
    private Boolean isFull;

}
