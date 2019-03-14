package com.vcb.domain.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by fangxm on 19-1-17.
 */
@Getter
@Setter
@ToString
public class SearchFinancingRequest extends KushenBaseRequest {
    private String mobile;
    private String varietyCode;
    private String financingSn;
    private Integer status;
    private Integer varietyId;
    private Integer pageNumber;
    private Integer pageSize;
}
