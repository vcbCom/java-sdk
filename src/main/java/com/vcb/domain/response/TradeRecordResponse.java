package com.vcb.domain.response;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 *  交易委托初始化
 * @author qxx
 */
@Getter
@Setter
public class TradeRecordResponse {

    /**
     * 币种code
     */
    private String varietyCode;

    /**
     * 类型名称
     */
    private String businessTypeName;

    /**
     * 交易所
     */
    private String exchangeCode;

    /**
     * 交易对
     */
    private String symbol;

    /**
     * 类型：1转入，2转出，3冻结，4解冻
     */
    private Integer type;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 金额类型：0其它,1本金，2借款，3利息
     */
    private Integer amountType;

    /**
     * createTime
     */
    private Date createTime;
}

