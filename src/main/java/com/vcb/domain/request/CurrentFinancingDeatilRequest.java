package com.vcb.domain.request;

import javax.validation.constraints.NotNull;

import com.vcb.domain.VcbPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 活期理财产品详情
 */
@Getter
@Setter
public class CurrentFinancingDeatilRequest extends KushenQueryBaseRequest {

    /**
     * 理财产品编号
     */
    @NotNull(payload = VcbPayload.MissingParameter.class,message="currentFinancingSn")
    private String currentFinancingSn;
}
