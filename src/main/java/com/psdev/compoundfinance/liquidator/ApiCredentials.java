package com.psdev.compoundfinance.liquidator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName="of")
public class ApiCredentials {
    // for setting in compound-api-key http header
    String key;
}
