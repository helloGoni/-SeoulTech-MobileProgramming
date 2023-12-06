package com.example.kmoocproject;

import java.util.LinkedHashMap;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("jsonschema2pojo")
public class Image {

    private String raw;
    private String small;
    private String large;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
