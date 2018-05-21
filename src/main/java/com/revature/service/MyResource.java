package com.revature.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.revature.model.Activity;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Activity getIt() {
    	Activity a = new Activity();
    	return a;
    }
    
    @POST
    @Produces(MediaType.APPLICATION_ATOM_XML)
    public String getPost() {
//    	id = 3;
        return "Post it! " + 0;
    }
    
    @GET
    @Path("/deep")
    @Produces(MediaType.TEXT_PLAIN)
    public String getFurther() {
//    	id = 3;
        return "deeper path";
    }

    @GET
    @Path("{resourceid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getId(@PathParam("resourceid") int id) {
        return "Got ID! " + id;
    }
}
