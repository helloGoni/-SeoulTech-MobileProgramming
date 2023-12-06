package com.example.kmoocproject;

import java.util.LinkedHashMap;
import java.util.Map;
//zimport javax.annotation.Generated;

//@Generated("jsonschema2pojo")
public class CourseImage {

    private String uri;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
