package com.aggregator.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.net.URIBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Abstract base class for HTTP API clients.
 * Handles common HTTP operations and JSON parsing.
 */
public abstract class AbstractAPIClient implements APIClient {
    protected static final ObjectMapper objectMapper = new ObjectMapper();
    protected final HttpClient httpClient;
    
    public AbstractAPIClient() {
        this.httpClient = HttpClients.createDefault();
    }
    
    /**
     * Builds a complete URL with query parameters.
     * 
     * @param params Query parameters
     * @return Built URL
     * @throws Exception if URL building fails
     */
    protected URI buildUri(Map<String, String> params) throws Exception {
        URIBuilder builder = new URIBuilder(getBaseUrl());
        
        if (params != null) {
            params.forEach(builder::addParameter);
        }
        
        return builder.build();
    }
    
    /**
     * Makes an HTTP GET request and returns the response as Object.
     * 
     * @param uri Target URI
     * @return Parsed JSON response
     * @throws Exception if the request fails
     */
    protected Object makeRequest(URI uri) throws Exception {
        HttpGet httpGet = new HttpGet(uri);
        httpGet.setHeader("User-Agent", "APIAggregator/1.0");
        
        try {
            return httpClient.execute(httpGet, response -> {
                if (response.getCode() != 200) {
                    throw new RuntimeException("API returned status " + response.getCode());
                }
                
                HttpEntity entity = response.getEntity();
                if (entity == null) {
                    throw new RuntimeException("Empty response");
                }
                
                String content = EntityUtils.toString(entity, StandardCharsets.UTF_8);
                return objectMapper.readValue(content, Object.class);
            });
        } finally {
            httpGet.releaseConnection();
        }
    }
}
