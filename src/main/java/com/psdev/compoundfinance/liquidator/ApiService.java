package com.psdev.compoundfinance.liquidator;

import com.google.common.collect.Lists;
import com.psdev.compoundfinance.liquidator.data.EthValue;
import com.psdev.compoundfinance.liquidator.data.GetAccountValueRequest;
import com.psdev.compoundfinance.liquidator.data.GetAccountValuesRequest;
import com.psdev.compoundfinance.liquidator.interceptor.ApiKeyHeaderRequestInterceptor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class ApiService extends AbstractService{

    public ApiService(ApiCredentials credentials) {

        rateLimitedRestTemplate = new RestTemplate(publicReadHttpRequestFactory());
        rateLimitedRestTemplate.setInterceptors(Collections.singletonList(
                new ApiKeyHeaderRequestInterceptor(Lists.newArrayList(riskApiRateLimiter), credentials)
        ));

        addObjectMapper(rateLimitedRestTemplate);
    }


    public String getTopAccountValuesString() {
        return rateLimitedRestTemplate.getForObject(BASE_URL + API_GROUP_RISK + RISK_API_TOP_ACCOUNT_VALUES,
                String.class);
    }

    public String getAccountValues() {
        return getAccountValuesString(null, null, null, null);
    }

    public String getAccountValuesString(Integer pageSize, Integer pageNumber,
                                     EthValue minBorrowValue, EthValue maxCollateralValue) {

        GetAccountValuesRequest req = new GetAccountValuesRequest();
        req.setPage_number(validatePageNumber(pageNumber));
        req.setPage_size(validatePageSize(pageSize));
        req.setMin_borrow_value_in_eth(validateMinBorrowValue(minBorrowValue));
        req.setMax_collateral_ratio(validateMaxCollateralValue(maxCollateralValue));

        ResponseEntity<String> response = rateLimitedRestTemplate
                .exchange(BASE_URL + API_GROUP_RISK + RISK_API_ACCOUNT_VALUES,
                        HttpMethod.POST, new HttpEntity(req, new HttpHeaders()), String.class);
        return response.getBody().toString();


    }

    public String getAccountValue(String accountAddress) {

        validateAddress(accountAddress);

        ResponseEntity<String> response = rateLimitedRestTemplate
                .exchange(BASE_URL + API_GROUP_RISK + RISK_API_ACCOUNT_VALUE,
                        HttpMethod.POST, new HttpEntity(new GetAccountValueRequest(accountAddress), new HttpHeaders()),
                        String.class);
        return response.getBody().toString();

    }


}
