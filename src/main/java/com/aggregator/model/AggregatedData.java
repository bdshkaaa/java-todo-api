package com.aggregator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.util.UUID;

/**
 * Wrapper for aggregated data from any API source.
 */
public class AggregatedData {
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("source")
    private String source;
    
    @JsonProperty("timestamp")
    private String timestamp;
    
    @JsonProperty("data")
    private Object data;
    
    public AggregatedData() {
        this.id = UUID.randomUUID().toString();
        this.timestamp = Instant.now().toString();
    }
    
    public AggregatedData(String source, Object data) {
        this();
        this.source = source;
        this.data = data;
    }
    
    // Getters and setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getSource() {
        return source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }
}
