package com.psdev.compoundfinance.liquidator.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString(callSuper=true, includeFieldNames=true)
public class PaginationSummary {
//     *     "pagination_summary": {
//     *         "total_pages": 1,
//     *         "total_entries": 56,
//     *         "page_size": 100,
//     *         "page_number": 1
//                *     },

    @JsonProperty
    Integer total_pages;
    @JsonProperty
    Integer total_entries;
    @JsonProperty
    Integer page_size;
    @JsonProperty
    Integer page_number;

}
