package com.vcb.domain.request;

import javax.validation.constraints.NotNull;

import com.vcb.domain.VcbPayload;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 借贷归还明细
 */
@Getter
@Setter
@ToString
public class TradeLoanReturnInfoRequest extends BaseRequest{

    /**
     *借币流水号
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "tradeLoanSn")
    private String tradeLoanSn;
}
