package com.vcb.domain.request;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.vcb.domain.VcbPayload;
import lombok.Getter;
import lombok.Setter;

/**
 * 活期理财产品列表
 */
@Getter
@Setter
public class CurrentFinancingBuyRequest extends KushenBaseRequest {


    /**
     * 理财编号
     */
    @NotNull(payload = VcbPayload.MissingParameter.class,message="currentFinancingSn")
    private String currentFinancingSn;

    /**
     * 购买数量
     */
    @NotNull(payload = VcbPayload.MissingParameter.class,message="amount")
    @DecimalMin(value = "0", payload = VcbPayload.InvalidParameter.class, inclusive = false,
        message = "must be grater than zero")
    private BigDecimal amount;
}
