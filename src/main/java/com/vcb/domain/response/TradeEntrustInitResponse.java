package com.vcb.domain.response;

import java.math.BigDecimal;
import java.util.Date;

import com.vcb.domain.Depth;
import com.vcb.domain.QueryResponse;
import com.vcb.domain.SymbolConfig;
import com.vcb.domain.response.SymbolInfoResponse.TradeAccountInfo;
import lombok.Getter;
import lombok.Setter;

/**
 *  交易委托初始化
 * @author qxx
 */
@Getter
@Setter
public class TradeEntrustInitResponse {

    /**
     * 当前委托
     */
    private QueryResponse<EntrustInfo> entrustList;

    /**
     * 交易对配置
     */
    private SymbolConfig symbolConfig;

    /**
     * 深度
     */
    private Depth depth;

    /**
     * 用户交易账户基本信息
     */
    private TradeAccountInfo tradeAccount;

    /**
     * 交易对
     */
    private String symbol;

    /**
     * 交易所
     */
    private String exchangeCode;

    /**
     * 兑换价格
     */
    private String price;

    /**
     * 折合人民币价格
     */
    private String cnyPrice;

    /**
     * usdt折合人民币比率
     */
    private BigDecimal financeRate;

    /**
     * 委托订单信息
     */
    @Getter
    @Setter
    public static class EntrustInfo {

        /**
         * 委托订单号
         */
        private String entrustSn;

        /**
         * 品种
         */
        private String varietyCode;

        /**
         * 计价品种
         */
        private String withVarietyCode;

        /**
         * 方向：1限价买入，2限价卖出，3市价买入，4市价卖出
         */
        private Integer type;

        /**
         * 成交总额
         */
        private String dealTotal;

        /**
         * 成交均价
         */
        private String dealPrice;

        /**
         * 成交数量
         */
        private String dealAmount;

        /**
         * 成交手续费
         */
        private String dealFee;

        /**
         * 未成交总量
         */
        private String notDealTotal;

        /**
         * 委托数量
         */
        private String amount;

        /**
         * 委托总额
         */
        private String total;

        /**
         * 委托单价
         */
        private String price;

        /**
         * 状态：1未成交，2部分成交，3部分成交撤销，4全部成交，5全部撤销
         */
        private Integer status;

        /**
         * 提交状态 1等待提交 2已提交 3等待撤销 4已提交撤销
         */
        private Integer submitStatus;

        /**
         * 强制类型：1非强制 2强制
         */
        private Integer forceType;

        /**
         * 委托时间
         */
        private Date createTime;
    }
}
