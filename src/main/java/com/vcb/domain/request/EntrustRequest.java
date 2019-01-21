package com.vcb.domain.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.vcb.domain.VcbPayload;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

/**
 * 委托
 */
@Getter
@Setter
@ToString
public class EntrustRequest extends BaseRequest{

    /**
     * 交易对
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "symbol")
    private String symbol;

    /**
     * 交易所
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "exchangeCode")
    private String exchangeCode;

    /**
     * 数量
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "amount")
    @DecimalMin(value = "0", payload = VcbPayload.InvalidParameter.class, inclusive = false,message = "must be grater than zero")
    private String amount;

    /**
     * 类型：1限价买入，2限价卖出，3市价买入，4市价卖出
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "type")
    @Range(payload = VcbPayload.InvalidParameter.class, min = 1, max = 4, message = "must be range between 1 and 4")
    private Integer type;

    /**
     * 限价价格
     */
    @DecimalMin(value = "0", payload = VcbPayload.InvalidParameter.class, inclusive = false,message = "must be grater than zero")
    private String price;
}
