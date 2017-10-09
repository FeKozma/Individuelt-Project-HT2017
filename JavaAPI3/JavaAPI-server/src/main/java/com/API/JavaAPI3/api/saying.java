package com.API.JavaAPI3.api;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonProperty;

public class saying {
    private long id;

    @Length(max = 3)
    private String content;

    public saying() {
        // Jackson deserialization
    }

    public saying(long id, String content) {
        this.id = id;
        this.content = content;
    }
    
    private String jj;
    public saying(String kk) {
    	this.jj = kk;
    	System.out.println( "\n" + kk + "\n");
    	}

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}