package com.vcb.domain.response;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by fangxm on 19-1-19.
 */
@Data
public class LoanInterestResponse {

    /**
     * 利率
     */
    private BigDecimal interestRate;
}
