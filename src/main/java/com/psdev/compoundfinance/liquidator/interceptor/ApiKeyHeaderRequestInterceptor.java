package com.psdev.compoundfinance.liquidator.interceptor;

import com.google.common.util.concurrent.RateLimiter;
import com.psdev.compoundfinance.liquidator.ApiCredentials;
import com.psdev.compoundfinance.liquidator.ApiService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.List;

public class ApiKeyHeaderRequestInterceptor implements ClientHttpRequestInterceptor {

    List<RateLimiter> rateLimiters;
    ApiCredentials credentials;

    public ApiKeyHeaderRequestInterceptor(List<RateLimiter> rl, ApiCredentials credentials) {
        this.credentials = credentials;
        this.rateLimiters = rl;
    }

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        for (RateLimiter r : rateLimiters) {
            r.acquire();
        }

        HttpHeaders headers = request.getHeaders();
        headers.set(ApiService.HEADER_KEY, credentials.getKey());
        return execution.execute(request, body);
    }

}
