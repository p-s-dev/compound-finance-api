package com.psdev.compoundfinance.liquidator;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.RateLimiter;
import com.psdev.compoundfinance.liquidator.data.EthValue;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.web3j.utils.Numeric.hexStringToByteArray;

abstract class AbstractService {

    public static RateLimiter riskApiRateLimiter = RateLimiter.create(1);
    RestTemplate rateLimitedRestTemplate;

    public static final String HEADER_KEY = "compound-api-key";

    public static final String BASE_URL_PREFIX = "https://";
    public static final String BASE_URL_SUFFIX = "/api/";
    public static final String API_GROUP_RISK = "risk/v1/";
    public static final String API_GROUP_MARKET_HISTORY = "market_history/v1/";

    public static final String RISK_API_TOP_ACCOUNT_VALUES = "get_top_account_values";
    public static final String RISK_API_ACCOUNT_VALUES = "get_account_values";
    public static final String RISK_API_ACCOUNT_VALUE = "get_account_value";

    public static final String MARKET_HISTORY_API_GRAPH = "get_market_history_graph";

    public static final Integer DEFAULT_PAGE_NUMBER = Integer.valueOf(1);
    public static final Integer DEFAULT_PAGE_SIZE = Integer.valueOf(10);
    public static final BigDecimal DEFAULT_MIN_BORROW = BigDecimal.ZERO;
    public static final BigDecimal DEFAULT_MAX_COLLAT = BigDecimal.valueOf(2);

    protected EthValue validateMaxCollateralValue(BigDecimal maxCollateralValue) {
        if (maxCollateralValue == null) {
            return new EthValue(DEFAULT_MAX_COLLAT);
        } else {
            return new EthValue(maxCollateralValue);
        }

    }

    protected EthValue validateMinBorrowValue(BigDecimal minBorrowValue) {
        if (minBorrowValue == null) {
            return new EthValue(DEFAULT_MIN_BORROW);
        } else {
            return new EthValue(minBorrowValue);
        }
    }

    protected void addObjectMapper(RestTemplate restTemplate) {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setPrettyPrint(false);

        messageConverter.setObjectMapper(objectMapper());
        restTemplate.getMessageConverters().removeIf(m -> m.getClass().getName().equals(MappingJackson2HttpMessageConverter.class.getName()));
        restTemplate.getMessageConverters().add(messageConverter);
    }

    protected ObjectMapper objectMapper() {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
        return om;
    }

    protected Integer validatePageNumber(Integer pageNumber) {
        if (pageNumber == null || pageNumber < 1) {
            return DEFAULT_PAGE_NUMBER;
        } else {
            return pageNumber;
        }
    }

    protected Integer validatePageSize(Integer pageSize) {
        if (pageSize == null || pageSize < 1) {
            return DEFAULT_PAGE_SIZE;
        } else {
            return pageSize;
        }
    }

    protected void validateAddress(String accountKey) {
        if (accountKey.length() != 40 &&  accountKey.length() != 42) {
            throw new InvalidAddressException("Invalid address length.");
        }

        if (!isValidAddress(hexStringToByteArray(accountKey))) {
            throw new InvalidAddressException("Invalid address.");
        }
    }

    public static boolean isValidAddress(byte[] addr) {
        return addr != null && addr.length == 20;
    }

}
