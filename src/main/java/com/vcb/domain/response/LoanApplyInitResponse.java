package com.vcb.domain.response;

import java.math.BigDecimal;

import lombok.Data;

/**
 * Created by fangxm on 19-1-19.
 */
@Data
public class LoanApplyInitResponse  {

    /**
     * 最小质押数量
     */
    private BigDecimal pledgeMin;

    /**
     * 质押借贷比例
     */
    private BigDecimal pledgeMaxRate;

    /**
     * 质押的币种
     */
    private String varietyCode;
    /**
     * 质押币种市价
     */
    private BigDecimal price;
    /**
     * 一个质押币种兑换UDST个数
     */
    private BigDecimal loanPrice;
    private Integer minLoanDays;
    private BigDecimal interestRate;
    private BigDecimal interestRatePercent;
    private BigDecimal minLoanInterestPercent;

}
