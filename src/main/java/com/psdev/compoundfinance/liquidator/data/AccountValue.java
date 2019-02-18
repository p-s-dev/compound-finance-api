package com.psdev.compoundfinance.liquidator.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountValue {
//    "account_value":
//        {
//            "total_supply_value_in_eth": {
//            "value": "62481637989287.00000000000000"
//        },
//            "total_borrow_value_in_eth": {
//            "value": "42638364754254.00000000000000"
//        },
//            "block_updated": 7237417,
//                "address": "0xc88b963239b6918f74c3298bb1dc079b92671e42"
//        }

    @JsonProperty
    EthValue total_supply_value_in_eth;
    @JsonProperty
    EthValue total_borrow_value_in_eth;
    @JsonProperty
    Long block_updated;
    @JsonProperty
    String address;
}
