package com.quinnox.jaxrsdownload.exception;

import java.util.Date;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.quinnox.jaxrsdownload.excepmodel.ErrorMessage;

@Provider
public class MissingFileExceptionMapper implements ExceptionMapper<MissingFileException>{

	
	public Response toResponse(MissingFileException ex) {
		ErrorMessage errorMessage=new ErrorMessage(new Date(), ex.getMessage(), "404", "");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
