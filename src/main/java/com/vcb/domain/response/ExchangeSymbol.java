package com.vcb.domain.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *  交易对列表
 * @author qxx
 */
@Getter
@Setter
@ToString
public class ExchangeSymbol {

    /**
     * 交易所名称
     */
    private String exchangeCode;

    /**
     * 该交易所支持的交易对信息
     */
    private List<SymbolInfo> symbols;

    /**
     * 交易对信息
     */
    @Getter
    @Setter
    public static class SymbolInfo {
        /**
         * 交易对
         */
        private String symbol;

        /**
         * 品种编码
         */
        private String varietyCode;

        /**
         * 计价品种编码
         */
        private String withVarietyCode;

        /**
         * 涨幅
         */
        private String increaseRatePercent;

        /**
         * 兑换价格
         */
        private String price;

        /**
         * 杠杆倍数
         */
        private Integer loanLever;

    }

}
