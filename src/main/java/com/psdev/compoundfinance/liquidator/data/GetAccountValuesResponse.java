package com.psdev.compoundfinance.liquidator.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.util.List;

@ToString(callSuper=true, includeFieldNames=true)
public class GetAccountValuesResponse {

    /**
     * {
     *     "request": {
     *         "page_size": 100,
     *         "page_number": 1,
     *         "min_borrow_value_in_eth": {
     *             "value": "0"
     *         },
     *         "max_collateral_ratio": {
     *             "value": "2"
     *         }
     *     },
     *     "pagination_summary": {
     *         "total_pages": 1,
     *         "total_entries": 56,
     *         "page_size": 100,
     *         "page_number": 1
     *     },
     *     "error": null,
     *     "account_values": [
     *         {
     *             "total_supply_value_in_eth": {
     *                 "value": "19507121389702.00000000000000"
     *             },
     *             "total_borrow_value_in_eth": {
     *                 "value": "1066532819210856.704788978240"
     *             },
     *             "block_updated": 7237051,
     *             "address": "0xbd56dba641a856a0afa8dc05bfe52368965bb04b"
     *         },
     *
     *
     */


    @JsonProperty
    GetAccountValuesRequest request;

    @JsonProperty
    PaginationSummary pagination_summary;

    @JsonProperty
    ErrorDetails error;

    @JsonProperty
    List<AccountValue> account_values;





}
