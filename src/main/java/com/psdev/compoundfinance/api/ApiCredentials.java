package com.psdev.compoundfinance.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName="of")
public class ApiCredentials {
    // for setting in compound-api-key http header
    String key;
}
