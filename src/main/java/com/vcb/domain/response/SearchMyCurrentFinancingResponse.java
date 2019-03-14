package com.vcb.domain.response;

import java.math.BigDecimal;

import com.vcb.domain.QueryResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * 已购理财列表
 */
@Getter
@Setter
public  class SearchMyCurrentFinancingResponse<T> {

    private QueryResponse<T> queryList;

    /**
     * 总资产折合BTC
     */
    private BigDecimal totalBTC;

    /**
     * 昨日收益折合BTC
     */
    private BigDecimal yesterdayProfitBTC;

    @Getter
    @Setter
    public static class CurrentFinancingDetail{

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
         * 币种id
         */
        private transient Integer varietyId;

        /**
         * 投资金额
         */
        private BigDecimal totalAmount;

        /**
         * 历史收益
         */
        private BigDecimal profit;

        /**
         * 昨日收益
         */
        private BigDecimal yesterdayProfit;

        /**
         * 七日年化利率
         */
        private BigDecimal sevenAnnualInterest;

        /**
         * 万分利率
         */
        private BigDecimal interest;
    }
}
