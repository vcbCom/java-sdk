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
     * 用户手机
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "mobile")
    private String mobile;
}
