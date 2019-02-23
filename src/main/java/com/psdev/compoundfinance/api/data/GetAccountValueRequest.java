package com.psdev.compoundfinance.api.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAccountValueRequest {
    @JsonProperty
    String account_address;
}
