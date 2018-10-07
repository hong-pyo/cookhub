package com.hong.cookhub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

/**
 * Created by hong2 on 2018. 10. 8.
 * Time : AM 12:52
 */

@Getter
@Builder
public class ApiError implements Serializable {
    private String message;
    @JsonProperty("documentation_url")
    private String documentationUrl;
}
