package com.vcb.domain.request;

import com.vcb.domain.VcbPayload;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by fangxm on 19-1-19.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoanApplyInitRequest extends BaseRequest {
    @NotBlank(payload = VcbPayload.MissingParameter.class,message="varietyCode")
    private String varietyCode;

}
