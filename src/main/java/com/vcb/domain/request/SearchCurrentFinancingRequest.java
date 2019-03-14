package com.vcb.domain.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 活期理财产品列表
 */
@Getter
@Setter
public class SearchCurrentFinancingRequest extends KushenQueryBaseRequest {
    /**
     * 币种
     */
    private String varietyCode;

    /**
     * 理财产品名称
     */
    private String currentFinancingName;
}
