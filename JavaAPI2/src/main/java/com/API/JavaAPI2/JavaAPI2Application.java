package com.API.JavaAPI2;

import com.API.JavaAPI2.health.templateHealthCheck;
import com.API.JavaAPI2.resources.APIResource;



import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class JavaAPI2Application extends Application<JavaAPI2Configuration>{

	
    public static void main(String[] args) throws Exception {
        new JavaAPI2Application().run(args);
        System.out.print("\n\n\ntest\n\n\n");
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<JavaAPI2Configuration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(JavaAPI2Configuration configuration,
                    Environment environment) {
        final APIResource resource = new APIResource(
        		configuration.getTemplate(),
        		configuration.getDefaultName()
        		);
        
        final templateHealthCheck healthCheck =
                new templateHealthCheck(configuration.getTemplate());
            environment.healthChecks().register("template", healthCheck);
            environment.jersey().register(resource);
            
        environment.jersey().register(resource);
        		}


}
