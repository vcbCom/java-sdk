package com.vcb.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 交易对配置
 * @author qxx on 2018/8/13.
 */
@Getter
@Setter
public class SymbolConfig {
    /**
     * 杠杆倍数
     */
    private Integer leverage;
    /**
     * 借贷利率
     */
    private String loanInterest;
    /**
     * 最小借贷单位
     */
    private Integer loanMinUnit;

    /**
     * 最小借贷数量
     */
    private String loanMinAmount;
    /**
     * 手续费率
     */
    private String tradeFee;

    /**
     * 交易量最小单位
     */
    private Integer minTradeUnit;

    /**
     * 限价价格最小单位
     */
    private Integer minPriceUnit;

    /**
     * 交易额最小单位
     */
    private Integer minTradeTotalUnit;

    /**
     * 市价买最小委托额
     */
    private String minTradeTotal;

    /**
     * 交易量最小数量
     */
    private String minTradeAmount;
    /**
     * 交易价格控制
     */
    private String tradePriceControl;
    /**
     * 预警线
     */
    private String warningRate;
    /**
     * 平仓线
     */
    private String forceRate;
}
