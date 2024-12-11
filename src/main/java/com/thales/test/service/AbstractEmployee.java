package com.thales.test.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

public class AbstractEmployee {

    @Value("${dummy.base-url}")
    protected String baseUrl;

    protected final RestTemplate restTemplate;

    public AbstractEmployee(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    protected HttpHeaders headersAdd (){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie","humans_21909=1");
        headers.set("Content-Type", "application/json");
        return headers;
    }
}
