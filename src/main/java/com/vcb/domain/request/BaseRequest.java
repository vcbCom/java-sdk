package com.vcb.domain.request;

import javax.validation.constraints.NotNull;

import com.vcb.domain.VcbPayload;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseRequest {
    /**
     * openid
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "openid")
    private String openid;
}
