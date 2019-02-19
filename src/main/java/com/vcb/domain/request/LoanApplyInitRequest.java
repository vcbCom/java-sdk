package com.vcb.domain.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by fangxm on 19-1-19.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoanApplyInitRequest extends BaseRequest {
    private String varietyCode;

}
