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
public class SearchLoanRequest extends BaseRequest {
    private String depositVarietyCode;
    private Integer depositVarietyId;
    private String mobile;
    private String loanSn;
    private Integer status;
    private Integer pageNumber;
    private Integer pageSize;
}
