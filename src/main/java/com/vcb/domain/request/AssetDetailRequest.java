package com.vcb.domain.request;

import javax.validation.constraints.NotNull;

import com.vcb.domain.VcbPayload;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 获取资产详情
 * @author qxx on 2019/1/16.
 */
@Getter
@Setter
@ToString
public class AssetDetailRequest {

    /**
     * 用户手机号
     */
    @NotNull(payload = VcbPayload.MissingParameter.class, message = "mobile")
    //@Pattern(regexp="^[1][3-57-9][0-9]{9}$",payload = VcbPayload.InvalidParameter.class,message="format error")
    private String mobile;

    /**
     * 资产类型loan	质押借款账户 financing	理财账户 trade	交易账户(杠杆账户)
     */
    private String type;

}
