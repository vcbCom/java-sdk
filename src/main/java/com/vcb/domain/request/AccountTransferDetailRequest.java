package com.vcb.domain.request;

import javax.validation.constraints.NotNull;

import com.vcb.domain.VcbPayload;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by fangxm on 19-1-28.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AccountTransferDetailRequest extends KushenBaseRequest {
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "sn")
    private String sn;
    private Boolean record;
}
