package com.vcb.domain.request;

import java.util.Date;

import com.vcb.domain.VcbPayload;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

/**
 * 交易资金记录
 */
@Getter
@Setter
public class AssetRecordRequest extends QueryBaseRequest{

    /**
     * 账户类型 1 基本账户 2 质押借款账户 3 理财账户
     */
    @Range(payload = VcbPayload.InvalidParameter.class, min = 0, max = 3, message = "must be range between 0 and 3")
    private Integer type;

    /**
     * 划转的币种
     */
    private String varietyCode;

    private Date startTime;

    private Date endTime;
}
