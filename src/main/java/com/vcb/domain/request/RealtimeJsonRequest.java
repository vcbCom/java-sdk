package com.vcb.domain.request;

import javax.validation.constraints.NotNull;

import com.vcb.domain.VcbPayload;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 获取实时的K线和深度
 */
@Getter
@Setter
@ToString
public class RealtimeJsonRequest{

    /**
     * 交易对编码 和 symbol一样 :btcusdt
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "variety")
    private String variety;

    /**
     * 交易所编码 和exchangeCode一样
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "exchange")
    private String exchange;
}
