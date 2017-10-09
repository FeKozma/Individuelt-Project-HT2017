package com.API.JavaAPI3;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;

import com.API.JavaAPI3.health.templateHealthCheck;
import com.API.JavaAPI3.resources.APIResource;
import com.API.JavaAPI3.resources.AddAd;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class JavaAPIApplication extends Application<JavaAPIConfiguration>{

	
    public static void main(String[] args) throws Exception {
        new JavaAPIApplication().run(args);
        System.out.print("\n\n\ntest\n\n\n");
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<JavaAPIConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(JavaAPIConfiguration configuration,
                    Environment environment) {
        final APIResource resource = new APIResource(
        		configuration.getTemplate(),
        		configuration.getDefaultName()
        		);
        final AddAd ad = new AddAd(
        		);
        
        final templateHealthCheck healthCheck =
                new templateHealthCheck(configuration.getTemplate());
            environment.healthChecks().register("template", healthCheck);
            environment.jersey().register(resource);
            environment.jersey().register(ad);
            
        environment.jersey().register(resource);
        environment.jersey().register(ad);
    
        enableCorsHeaders(environment);
    }
    
    private void enableCorsHeaders (Environment env) {
    	 final FilterRegistration.Dynamic cors = env.servlets().addFilter("CORS", CrossOriginFilter.class);

         // Configure CORS parameters
    	 cors.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "http://localhost:4200");
         cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "http://localhost:4200");
         cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin");
         cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");

         // Add URL mapping
         cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }

}
