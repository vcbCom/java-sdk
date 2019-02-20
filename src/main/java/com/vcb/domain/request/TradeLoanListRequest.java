package com.vcb.domain.request;

import java.util.Date;

import com.vcb.domain.VcbPayload;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

/**
 * 借贷记录
 */
@Getter
@Setter
@ToString
public class TradeLoanListRequest extends QueryBaseRequest {

    /**
     * 归还状态0全部 1待归还 (未归还,部分归还) 2已归还
     */
    @Range(payload = VcbPayload.InvalidParameter.class, min = 0, max = 2, message = "must be range between 0 and 2")
    private Integer returnStatus = 0;

    /**
     * 借贷品种
     */
    private String loanVarietyCode ;

    /**
     * 查询开始时间 yyyy-MM-dd
     */
    private Date startTime;

    /**
     * 查询结束时间 yyyy-MM-dd
     */
    private Date endTime;
}
