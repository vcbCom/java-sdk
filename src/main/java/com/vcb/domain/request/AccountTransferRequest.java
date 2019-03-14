package com.vcb.domain.request;

import javax.validation.constraints.NotNull;

import com.vcb.domain.VcbPayload;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by fangxm on 19-1-16.
 */
@Getter
@Setter
@ToString
public class AccountTransferRequest extends KushenBaseRequest {
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "mobile")
    private String mobile;
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "varietyCode")
    private String varietyCode;
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "amount")
    private String amount;
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "type")
    private String type;
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "direct")
    private String direct;
    private String symbol;
    private String exchangeCode;
}
