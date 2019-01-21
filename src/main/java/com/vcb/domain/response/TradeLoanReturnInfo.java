package com.vcb.domain.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 *  借贷列表数据项
 * @author qxx
 */
@Getter
@Setter
public class TradeLoanReturnInfo {

    /**
     * 归还日期
     */
    private Date createTime;

    /**
     *归还数量
     */
    private String amount;
}

