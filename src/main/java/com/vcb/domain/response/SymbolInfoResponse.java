package com.vcb.domain.response;

import com.vcb.domain.Ticker;
import lombok.Getter;
import lombok.Setter;

/**
 *  交易对详情
 * @author qxx
 */
@Getter
@Setter
public class SymbolInfoResponse {

    /**
     * 交易账户基本信息
     */
    private TradeAccountInfo tradeAccount;

    /**
     * 交易信息
     */
    private Ticker ticker;

    /**
     * 交易对
     */
    private String symbol;

    /**
     * 交易所
     */
    private String exchangeCode;

    /**
     *兑换价格
     */
    private String financeRate;

    /**
     *折合人民币价格
     */
    private String cnyPrice;


    @Getter
    @Setter
    public static class TradeAccountInfo {

        /**
         *品种
         */
        private String varietyCode;
        /**
         *计价品种
         */
        private String withVarietyCode;
        /**
         * 交易所
         */
        private String exchangeCode;
        /**
         *品种可用金额
         */
        private String availableVariety;
        /**
         *品种冻结金额
         */
        private String freezeVariety;
        /**
         *计价品种可用金额
         */
        private String availableWithVariety;
        /**
         *计价品种冻结金额
         */
        private String freezeWithVariety;

    }
}

