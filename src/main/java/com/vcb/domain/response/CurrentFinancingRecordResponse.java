package com.vcb.domain.response;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 产品交易记录
 */
@Getter
@Setter
public  class CurrentFinancingRecordResponse {

    /**
     * 币种编码
     */
    private String varietyCode;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 产品主键
     */
    private Long currentFinancingId;

    /**
     * 理财编号
     */
    private String currentFinancingSn;

    /**
     * 理财名称
     */
    private String currentFinancingName;

    /**
     * 币种编码
     */
    private Integer varietyId;

    /**
     * 数量
     */
    private BigDecimal amount;

    /**
     * 类型：1转入，2转出，3冻结，4解冻
     */
    private Integer type;

    /**
     * 金额类型：1本金，2收益 3其他(活期转入转出)
     */
    private Integer amountType;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 时间
     */
    private Date createTime;
}
