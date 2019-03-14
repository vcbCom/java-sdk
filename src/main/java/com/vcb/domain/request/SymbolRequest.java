package com.vcb.domain.request;

import javax.validation.constraints.NotNull;

import com.vcb.domain.VcbPayload;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 交易对详情
 */
@Getter
@Setter
@ToString
public class SymbolRequest extends KushenBaseRequest {

    /**
     * 交易对
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "symbol")
    private String symbol;

    /**
     * 交易所
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "exchangeCode")
    private String exchangeCode;
}
