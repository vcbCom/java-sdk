package com.vcb.domain.response;

import java.math.BigDecimal;

import lombok.Data;

/**
 * Created by fangxm on 19-1-19.
 */
@Data
public class PledgeRateResponse {

    /**
     * 最小质押数量
     */
    private BigDecimal pledgeMin;

    /**
     * 质押借贷比例
     */
    private BigDecimal pledgeMaxRate;

    /**
     * 抵押借款最小现金金额
     */
    private BigDecimal pledgeMinCurrency;
}
