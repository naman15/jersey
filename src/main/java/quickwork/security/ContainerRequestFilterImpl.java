package quickwork.security;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.Provider;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;


@Provider
public class ContainerRequestFilterImpl implements ContainerRequestFilter{

	private static final String API_KEY_HEADER = "X-API-KEY";
	private static final String API_KEY_VALUE = "apikey123";

	public ContainerRequest filter(ContainerRequest request) 
	{
		String apiKey = request.getHeaderValue(API_KEY_HEADER);
		System.out.println("Called Filter");
		if(!API_KEY_VALUE.contentEquals(apiKey)) 
		{
			ResponseBuilder builder = null;
	        String response = "Denied Access";
	        builder = Response.status(Response.Status.UNAUTHORIZED).entity(response);
	        throw new WebApplicationException(builder.build());
		}
		return request;
	}

	

}
