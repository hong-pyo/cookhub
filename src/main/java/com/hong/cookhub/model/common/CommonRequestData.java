package com.hong.cookhub.model.common;

import lombok.Builder;
import lombok.Getter;

/**
 * Created by hong2 on 2018. 10. 15.
 * Time : PM 11:34
 */

@Builder
@Getter
public class CommonRequestData {
    private String userAgent;
    private String sessionId;
}
