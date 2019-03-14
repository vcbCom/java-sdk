package com.vcb.domain.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CurrentFinancingDetailResponse {
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
     * 剩余募集金额
     */
    private BigDecimal remainder;

    /**
     * 理财账户可用
     */
    private BigDecimal available;

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
     * 七天的利率集合
     */
    private List<SevenInterest> sevenInterests;

    /**
     * 七日年化利率
     */
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SevenInterest {
        /**
         * 七日年化利率
         */
        private BigDecimal sevenAnnualInterest;
        /**
         * 万分利率
         */
        private BigDecimal interest;

        /**
         * 日期 yyyyMMdd
         */
        private Integer day;
    }
}