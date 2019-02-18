package com.psdev.compoundfinance.liquidator.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class EthValue {
    @JsonProperty
    BigDecimal value;
}
