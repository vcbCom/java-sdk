package com.vcb.domain.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class TradeLoanRequest extends BaseRequest{
    /**
     * 交易对
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "symbol")
    private String symbol;

    @NotNull(payload = VcbPayload.MissingParameter.class, message = "mobile")
    @Pattern(regexp= "^[1][3-57-9][0-9]{9}$",payload = VcbPayload.InvalidParameter.class,message="format error")
    private String mobile;
    /**
     * 交易所
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "exchangeCode")
    private String exchangeCode;

    /**
     * 借贷品种
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "loanVarietyCode")
    private String loanVarietyCode;

    /**
     * 借贷数量
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "amount")
    @DecimalMin(value = "0", payload = VcbPayload.InvalidParameter.class, inclusive = false,message = "must be grater than zero")
    private String amount;
}
