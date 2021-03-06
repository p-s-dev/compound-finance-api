package com.psdev.compoundfinance.api.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString(callSuper=true, includeFieldNames=true)
public class ErrorDetails {
    //{"error":{"message":"account_address not found","field_errors":{},"error_code":2},"account_value":null}

    @JsonProperty
    String message;

    @JsonProperty
    Map field_errors;

    @JsonProperty
    Integer error_code;

}
