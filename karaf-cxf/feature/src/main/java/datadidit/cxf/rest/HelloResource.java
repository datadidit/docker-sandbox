package datadidit.cxf.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class HelloResource {
	@GET
	@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
	public Response sayHello(){
		return Response.ok("Hello World").build();
	}
	
	@GET
	@Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
	@Path("{name}")
	public Response sayHelloToSomeone(@PathParam("name") @DefaultValue("world") String name){
		return Response.ok("Hello "+name).build();
	}
}
