package com.vcb.domain.response;

import lombok.Getter;
import lombok.Setter;

/**
 *  交易对详情
 * @author qxx
 */
@Getter
@Setter
public class TradeLoanInitResponse {

    /**
     * 品种编码
     */
    private String varietyCode;

    /**
     *计价品种编码
     */
    private String withVarietyCode;

    /**
     * 交易所
     */
    private String exchangeCode;

    /**
     *品种已借数量
     */
    private String loanVarietyAmount;

    /**
     *计价品种已借数量
     */
    private String loanWithVarietyAmount;

    /**
     *借贷最小数量
     */
    private String loanMinAmount;

    /**
     *借贷最小单位
     */
    private Integer loanMinUnit;

    /**
     *杠杆倍数
     */
    private Integer loanLever;

    /**
     *品种借贷日利率
     */
    private String interest;

    /**
     *计价品种借贷日利率
     */
    private String withInterest;

    /**
     *计价品种借贷日利率
     */
    private String loanableAmount;

    /**
     *计价品种可借数量
     */
    private String withLoanableAmount;

}

