package com.vcb.domain.request;

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
public class AssetDetailRequest extends KushenBaseRequest {

    /**
     * 资产类型loan	质押借款账户 financing	理财账户 trade	交易账户(杠杆账户)
     */
    private String type;

}
