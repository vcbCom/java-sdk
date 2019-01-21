package com.vcb.domain.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.vcb.domain.VcbPayload;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 借贷归还
 */
@Getter
@Setter
@ToString
public class TradeLoanReturnRequest extends BaseRequest{

    /**
     *借币流水号
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "tradeLoanSn")
    private String tradeLoanSn;

    /**
     * 归还数量
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "amount")
    @DecimalMin(value = "0", payload = VcbPayload.InvalidParameter.class, inclusive = false,message = "must be grater than zero")
    private String amount;
}
