package com.example.kmoocproject;

import java.util.LinkedHashMap;
import java.util.Map;
//import javax.annotation.Generated;

    //@Generated("jsonschema2pojo")
    public class Pagination {

        private long count;
        private Object previous;
        private long numPages;
        private String next;
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }

        public Object getPrevious() {
            return previous;
        }

        public void setPrevious(Object previous) {
            this.previous = previous;
        }

        public long getNumPages() {
            return numPages;
        }

        public void setNumPages(long numPages) {
            this.numPages = numPages;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
