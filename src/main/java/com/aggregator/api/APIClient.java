package com.aggregator.api;

import java.util.Map;

/**
 * Interface for API clients.
 * Implementations must provide concrete API integrations.
 */
public interface APIClient {
    /**
     * Fetches data from the API.
     * 
     * @param params Query parameters
     * @return API response as Object (usually a Map or parsed JSON)
     * @throws Exception if the API call fails
     */
    Object fetchData(Map<String, String> params) throws Exception;
    
    /**
     * Gets the name/identifier of this API.
     * 
     * @return API name
     */
    String getApiName();
    
    /**
     * Gets the base URL of the API.
     * 
     * @return Base URL
     */
    String getBaseUrl();
}
