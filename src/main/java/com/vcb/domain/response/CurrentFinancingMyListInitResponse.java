package com.vcb.domain.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by fangxm on 19-3-12.
 */
@Getter
@Setter
public class CurrentFinancingMyListInitResponse {
    private Integer varietyId;
    private String varietyCode;
    private List<CurrentFinancingNameResponse> currentFinancingList;

    @Getter
    @Setter
    public static class CurrentFinancingNameResponse {
        private Long currentFinancingId;
        private String currentFinancingName;
    }
}
