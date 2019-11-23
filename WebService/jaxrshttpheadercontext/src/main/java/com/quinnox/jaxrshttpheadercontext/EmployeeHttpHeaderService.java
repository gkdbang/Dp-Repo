package com.quinnox.jaxrshttpheadercontext;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("/http-header")
public class EmployeeHttpHeaderService {
		
	    // How to read header parameter in jax-rs
		@GET
		@Path("/query")
		public Response queryHeaderInfo(@Context HttpHeaders httpHeaders){
			// reading specific header parameter from request
			String cacheControl=httpHeaders.getRequestHeader("Cache-Control").get(0);
			System.out.println("Cache-Control : "+cacheControl);
			
			// Reading all header parameters from request
			Set<Entry<String, List<String>>> headerKeys=httpHeaders.getRequestHeaders().entrySet();
			for (Entry<String, List<String>> entry : headerKeys) {
				//System.out.println(entry);
				//System.out.println(entry.getKey()+" : "+entry.getValue());
				System.out.println(entry.getKey()+" : "+entry.getValue().iterator().next());
			}
/*			 Set<String> headerKeys = httpHeaders.getRequestHeaders().keySet();
		        for(String header:headerKeys){
		            System.out.println(header+":"+httpHeaders.getRequestHeader(header).get(0));
		        }*/
			
			return Response.status(200).entity("Successfully received all the header parameters").build();
		}
	
}
