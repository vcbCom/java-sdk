package com.vcb.domain.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by fangxm on 19-1-18.
 */
@Getter
@Setter
@ToString
public class AccountDetailRequest extends BaseRequest {
    private String type;
}
