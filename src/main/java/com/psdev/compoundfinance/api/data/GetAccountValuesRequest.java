package com.psdev.compoundfinance.api.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetAccountValuesRequest {
    @JsonProperty
    Integer page_size;
    @JsonProperty
    Integer page_number;
    @JsonProperty
    EthValue min_borrow_value_in_eth;
    @JsonProperty
    EthValue max_collateral_ratio;

}
