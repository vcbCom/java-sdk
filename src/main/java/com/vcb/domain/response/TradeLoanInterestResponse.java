package com.vcb.domain.response;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 *  交易对借贷利率
 * @author qxx
 */
@Getter
@Setter
public class TradeLoanInterestResponse {

    /**
     *品种借贷日利率
     */
    private BigDecimal interest;

    /**
     *计价品种借贷日利率
     */
    private BigDecimal withInterest;
}

