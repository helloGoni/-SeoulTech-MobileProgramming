package com.example.kmoocproject;


import java.util.LinkedHashMap;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("jsonschema2pojo")
public class CourseVideo {

    private Object uri;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Object getUri() {
        return uri;
    }

    public void setUri(Object uri) {
        this.uri = uri;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}