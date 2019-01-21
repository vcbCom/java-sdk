package com.vcb.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ticker {

    /**
     * 开盘价
     */
    private String open;

    /**
     * 最高价
     */
    private String high;

    /**
     * 最低价
     */
    private String low;

    /**
     * 卖1
     */
    private String sell;

    /**
     * 买1
     */
    private String buy;

    /**
     * 收盘价|当前价
     */
    private String last;

    /**
     * 成交量
     */
    private String vol;

    /**
     * 时间
     */
    private Date time;

    /**
     * 涨幅百分比
     */
    private String rate;
    //private Boolean up;

}
