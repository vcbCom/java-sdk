package com.vcb.domain.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 交易委托
 *
 * @author qxx
 */
@Getter
@Setter
@ToString
public class EntrustResponse {

    /**
     * 委托订单号
     */
    private String entrustSn;

    /**
     * 委托数量
     */
    private String amount;

    /**
     * 委托单价
     */
    private String price;
}

