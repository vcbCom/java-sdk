package com.vcb.domain.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 借币归还初始化
 *
 * @author qxx
 */
@Getter
@Setter
public class TradeLoanReturnInitResponse {

    /**
     * 申请日期
     */
    private Date createTime;

    /**
     * 交易对
     */
    private String symbol;

    /**
     * 交易所
     */
    private String exchangeCode;

    /**
     * 借币流水号
     */
    private String tradeLoanSn;

    /**
     * 借贷币种
     */
    private String loanVarietyCode;

    /**
     * 归还状态 1未归还 2部分归还 3已归还
     */
    private Integer returnStatus;

    /**
     * 借币数量
     */
    private String loanAmount;

    /**
     * 归还数量
     */
    private String returnAmount;

    /**
     * 未还数量
     */
    private String dueAmount;

    /**
     * 利息
     */
    private String interestAmount;

    /**
     * 借币利率
     */
    private String loanInterest;

    /**
     * 状态，1待处理，2借币成功，3借币失败，4借币撤销，5借币完成
     */
    private Integer status;

    /**
     * 账户可用金额
     */
    private String availableVariety;
}

