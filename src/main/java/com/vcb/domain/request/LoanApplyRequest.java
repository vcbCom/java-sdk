package com.vcb.domain.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.vcb.domain.VcbPayload;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by fangxm on 19-1-17.
 */
@Getter
@Setter
@ToString
public class LoanApplyRequest extends BaseRequest {

    @NotBlank(payload = VcbPayload.MissingParameter.class,message="depositVarietyCode")
    private String depositVarietyCode;
    @NotBlank(payload = VcbPayload.MissingParameter.class,message="depositAmount")
    private BigDecimal depositAmount;
    @NotBlank(payload = VcbPayload.MissingParameter.class,message="loanAmount")
    private BigDecimal loanAmount;
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "mobile")
    private String mobile;

}
