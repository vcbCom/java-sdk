package com.vcb.domain.request;

import com.vcb.domain.VcbPayload;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

/**
 * 委托列表
 */
@Getter
@Setter
@ToString
public class EntrustListRequest extends KushenQueryBaseRequest {

    /**
     * 列表类型: 1 当前 2 历史
     */
    @Range(payload = VcbPayload.InvalidParameter.class, min = 1, max = 2, message = "must be range between 1 and 2")
    private Integer listType = 1;

    /**
     * 交易对
     */
    private String symbol;

    /**
     * 交易所
     */
    private String exchangeCode;

    /**
     * 交易方向 0或者null-全部 1-买 2-卖
     */
    @Range(payload = VcbPayload.InvalidParameter.class, min = 0, max = 2, message = "must be range between 0 and 2")
    private Integer direct;

    /**
     * 开始时间:yyyy-MM-dd  GMT+8
     */
    private String startTime;

    /**
     * 结束时间:yyyy-MM-dd  GMT+8
     */
    private String endTime;
}
