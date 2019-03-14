package com.vcb.domain.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 活期理财产品列表
 */
@Getter
@Setter
public class CurrentFinancingRecordRequest extends KushenQueryBaseRequest {
    /**
     * 币种
     */
    private String varietyCode;

    /**
     * 项目名称
     */
    private String currentFinancingName;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;
}
