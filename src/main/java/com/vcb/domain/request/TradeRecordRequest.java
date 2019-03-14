package com.vcb.domain.request;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 交易资金记录
 */
@Getter
@Setter
public class TradeRecordRequest extends KushenQueryBaseRequest {

    /**
     * 品种
     */
    private String varietyCode;

    /**
     * 交易所
     */
    private String exchangeCode;

    private String symbol;

    private Date startTime;

    private Date endTime;
}
