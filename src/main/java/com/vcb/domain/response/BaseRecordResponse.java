package com.vcb.domain.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 *  基本 质押 理财 账户转账记录
 * @author qxx
 */
@Getter
@Setter
public class BaseRecordResponse {

    /**
     * 币种code
     */
    private String varietyCode;

    /**
     * 类型名称
     */
    private String businessTypeName;

    /**
     * 类型：1转入，2转出，3冻结，4解冻
     */
    private Integer type;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * createTime
     */
    private Date createTime;
}

