package com.example.kmoocproject;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
//import javax.annotation.Generated;

//@Generated("jsonschema2pojo")
public class Example {

    private Pagination pagination;
    private List<Result> results;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
