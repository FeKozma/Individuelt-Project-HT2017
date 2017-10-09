package com.API.JavaAPI3.resources;

/*

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.API.JavaAPI2.api.saying;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

@Path("/hi")
@Produces(MediaType.APPLICATION_JSON)
public class AddAd {

	private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public AddAd(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new saying(counter.incrementAndGet(), value);
    }
}

*/

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.API.JavaAPI3.api.saying;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

@Path("/addad/{longitude}/{latitude}/{radius}/{company}/{summary}/{days}/{nrViews}")
@Produces(MediaType.APPLICATION_JSON)
public class AddAd {

	

	

	    public AddAd() {
	      
	    }

	    @GET
	    @Timed
	    public saying addAdfunk(@PathParam("longitude") Optional<String> lng, 
	    		@PathParam("latitude") Optional<String> lat,
	    		@PathParam("radius") Optional<String> radius,
	    		@PathParam("company") Optional<String> company,
	    		@PathParam("summary") Optional<String> summary,
	    		@PathParam("days") Optional<String> days,
	    		@PathParam("nrViews") Optional<String> views) {
	        String retVal = "No latitude fund";
	    	
	        System.out.println("\naddAdfunk\n");
	        
	    	if(lat.isPresent()) {
	        	retVal = lat.get();
	        }
	        return new saying(1, "your message was resievd");
	    }
	
}
