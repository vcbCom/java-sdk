package com.vcb.domain.request;

import javax.validation.constraints.NotNull;

import com.vcb.domain.VcbPayload;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 委托详情
 */
@Getter
@Setter
@ToString
public class EntrustInfoRequest extends BaseRequest{

    /**
     * 委托流水号
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "entrustSn")
    private String entrustSn;
}
