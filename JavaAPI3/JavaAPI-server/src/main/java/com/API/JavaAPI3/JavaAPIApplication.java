package com.API.JavaAPI3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

import io.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;

public class JavaAPIApplication extends Application<JavaAPIConfiguration>{

	
    public static void main(String[] args) throws Exception {
        new JavaAPIApplication().run(args);
        
        String databaseURL = "jdbc:mariadb://localhost:3306/Location";
        String user = "root";
        String pass = "admin";
        Connection conn = null;
        /*
        try {
        	   Driver myDriver = new oracle.jdbc.driver.OracleDriver();
        	   DriverManager.registerDriver( myDriver );
        	}
        	catch(ClassNotFoundException ex) {
        	   System.out.println("Error: unable to load driver class!");
        	   System.exit(1);
        	}*/
        
        try {
        	DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
        	//Class.forName(/*com?*/"org.mariadb.jdbc.Driver"); //TODO: create class
        	conn = DriverManager.getConnection(databaseURL, user, pass);
        	if (conn != null)
        	{
        		System.out.println("\nConnected to the database\n");
        	}
        } catch (ClassNotFoundException ex) {
        	System.out.println("\nDid no find database driver class\n");
        	ex.printStackTrace();
        }
       	catch (SQLException ex) {
       		System.out.println("\nAn error occurred while connecting to database\npleas check username and password\n");
       		ex.printStackTrace();
       	} finally {
       		if (conn != null) {
       			try {
       				System.out.println("\ntrying to close database connection\n");
       			conn.close();
        			System.out.println("\nconnection with database closed\n");
       			}
       			catch (SQLException ex){
       				ex.printStackTrace();
       			}
       		}
       	}
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
                    Environment environment) throws ClassNotFoundException {
        final APIResource resource = new APIResource(
        		configuration.getTemplate(),
        		configuration.getDefaultName()
        		);
        
        final AddAd ad = new AddAd(
        		);
        /*
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "postgresql");
        final UserDAO dao = jdbi.onDemand(UserDAO.class);
        environment.jersey().register(new UserResource(dao));
        */
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
