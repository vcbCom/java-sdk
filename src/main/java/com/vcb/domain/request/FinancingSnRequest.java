package com.vcb.domain.request;

import com.vcb.domain.VcbPayload;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by fangxm on 19-1-24.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FinancingSnRequest extends KushenBaseRequest {
    @NotBlank(payload = VcbPayload.MissingParameter.class,message="financingSn")
    private String financingSn;
}
