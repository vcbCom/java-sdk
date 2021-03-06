package com.vcb.domain.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 分页查询基类
 *
 * @author qxx
 */
@Getter
@Setter
@ToString
public class KushenQueryBaseRequest extends KushenBaseRequest {
    private int pageNum = 1;
    private int pageSize = 10;
}
