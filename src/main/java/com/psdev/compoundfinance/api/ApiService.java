package com.psdev.compoundfinance.api;

import com.google.common.collect.Lists;
import com.psdev.compoundfinance.api.data.GetAccountValueRequest;
import com.psdev.compoundfinance.api.data.GetAccountValueResponse;
import com.psdev.compoundfinance.api.data.GetAccountValuesRequest;
import com.psdev.compoundfinance.api.data.GetAccountValuesResponse;
import com.psdev.compoundfinance.api.interceptor.ApiKeyHeaderRequestInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Collections;

public class ApiService extends AbstractService{

    private String TOP_ACCOUNT_VALUES_URL;
    private String GET_ACCOUNT_VALUES_URL;
    private String GET_ACCOUNT_VALUE_URL;

    public ApiService(ApiCredentials credentials, String hostname) {

        TOP_ACCOUNT_VALUES_URL =
                BASE_URL_PREFIX +
                hostname +
                BASE_URL_SUFFIX +
                API_GROUP_RISK +
                RISK_API_TOP_ACCOUNT_VALUES;

        GET_ACCOUNT_VALUES_URL =
                BASE_URL_PREFIX +
                        hostname +
                        BASE_URL_SUFFIX +
                        API_GROUP_RISK +
                        RISK_API_ACCOUNT_VALUES;

        GET_ACCOUNT_VALUE_URL =
                BASE_URL_PREFIX +
                        hostname +
                        BASE_URL_SUFFIX +
                        API_GROUP_RISK +
                        RISK_API_ACCOUNT_VALUE;

        rateLimitedRestTemplate = new RestTemplate(publicReadHttpRequestFactory());
        rateLimitedRestTemplate.setInterceptors(Collections.singletonList(
                new ApiKeyHeaderRequestInterceptor(Lists.newArrayList(riskApiRateLimiter), credentials)
        ));

        addObjectMapper(rateLimitedRestTemplate);
    }


    public GetAccountValuesResponse getTopAccountValuesString() {
        return rateLimitedRestTemplate.getForObject(TOP_ACCOUNT_VALUES_URL, GetAccountValuesResponse.class);
    }

    public GetAccountValuesResponse getAccountValues() {
        return getAccountValues(null, null, null, null);
    }
    public GetAccountValuesResponse getAccountValues(Integer pageSize, Integer pageNumber,
                                                     BigDecimal minBorrowValue, BigDecimal maxCollateralValue) {
        GetAccountValuesRequest req =
                getGetAccountValuesRequest(pageSize, pageNumber, minBorrowValue, maxCollateralValue);
        return rateLimitedRestTemplate.exchange(GET_ACCOUNT_VALUES_URL,
                HttpMethod.POST, new HttpEntity(req, new HttpHeaders()),
                GetAccountValuesResponse.class).getBody();
    }

    public GetAccountValueResponse getAccountValue(String accountAddress) {
        validateAddress(accountAddress);
        return rateLimitedRestTemplate.exchange(GET_ACCOUNT_VALUE_URL,
                HttpMethod.POST, new HttpEntity(new GetAccountValueRequest(accountAddress), new HttpHeaders()),
                GetAccountValueResponse.class).getBody();
    }

    @ConfigurationProperties(prefix = "compound.read.rest.connection")
    public HttpComponentsClientHttpRequestFactory publicReadHttpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory();
    }

    private GetAccountValuesRequest getGetAccountValuesRequest(Integer pageSize, Integer pageNumber, BigDecimal minBorrowValue, BigDecimal maxCollateralValue) {
        GetAccountValuesRequest req = new GetAccountValuesRequest();
        req.setPage_number(validatePageNumber(pageNumber));
        req.setPage_size(validatePageSize(pageSize));
        req.setMin_borrow_value_in_eth(validateMinBorrowValue(minBorrowValue));
        req.setMax_collateral_ratio(validateMaxCollateralValue(maxCollateralValue));
        return req;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Deprecated
    public String getAccountValuesString(Integer pageSize, Integer pageNumber,
                                         BigDecimal minBorrowValue, BigDecimal maxCollateralValue) {
        GetAccountValuesRequest req =
                getGetAccountValuesRequest(pageSize, pageNumber, minBorrowValue, maxCollateralValue);
        return rateLimitedRestTemplate.exchange(GET_ACCOUNT_VALUES_URL,
                HttpMethod.POST, new HttpEntity(req, new HttpHeaders()), String.class).getBody();
    }

    @Deprecated
    public String getAccountValueString(String accountAddress) {
        validateAddress(accountAddress);
        return rateLimitedRestTemplate.exchange(GET_ACCOUNT_VALUE_URL,
                HttpMethod.POST, new HttpEntity(new GetAccountValueRequest(accountAddress), new HttpHeaders()),
                String.class).getBody();
    }

}
