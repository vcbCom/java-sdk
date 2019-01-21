package com.vcb.domain.response;

import java.util.Date;
import java.util.List;

import com.vcb.domain.response.TradeEntrustInitResponse.EntrustInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * 交易委托
 *
 * @author qxx
 */
@Getter
@Setter
public class EntrustInfoResponse {

    /**
     * 委托详情
     */
    private EntrustInfo entrustInfo;

    /**
     * 成交列表
     */
    private List<Deal> dealList;

    @Getter
    @Setter
    public static class Deal {

        /**
         *成交时间
         */
        private Date createTime;

        /**
         *成交手续费
         */
        private String dealFee;

        /**
         *成交数量
         */
        private String dealAmount;

        /**
         *成交均价
         */
        private String dealPrice;
    }
}

