package com.vcb.domain;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 深度
 * Created by qxx .
 */
@Getter
@Setter
@ToString
public class Depth {

    /**
     * 卖1,卖2,卖3
     */
    private List<List<String>> asks;

    /**
     * 买1,买2,买3
     */
    private List<List<String>> bids;

    /**
     * 时间
     */
    private Date time;
}
