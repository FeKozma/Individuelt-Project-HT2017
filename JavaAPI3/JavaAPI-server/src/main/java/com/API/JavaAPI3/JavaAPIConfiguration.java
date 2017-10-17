package com.API.JavaAPI3;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class JavaAPIConfiguration extends Configuration {
	@NotEmpty
    private String template = "empty";

    @NotEmpty
    private String defaultName = "Stranger";

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    //test
    /*
    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }*/
    /*
	@Valid
	@NotNull
	@JsonProperty
	private DataSourceFactory database = new DatabaseSourceFactory();
	*/
	/*
	@JsonProperty("database")
	public void setDataSourceFactory(DataSourceFactory factory) {
		this.database = factory;
	}
	
	*//*
	
	public DataSourceFactory getDataSourceFactory() {
		return database;
	}*/
}
