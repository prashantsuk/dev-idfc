package com.edms.exception;

import static com.edms.util.Constants.*;

import com.edms.model.MetricsResponse;
import com.edms.util.Constants;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Produces
@Singleton
@Requires(classes = { GlobalException.class, ExceptionHandler.class })
@Slf4j
public class GlobalExceptionHandler implements ExceptionHandler<GlobalException, HttpResponse> {

	@Override
	public HttpResponse<MetricsResponse> handle(HttpRequest request, GlobalException exception) {

		log.error(Constants.EXCEPTION_OCCURED, exception);

		MetricsResponse responseMsg = MetricsResponse.builder().error(exception.getMessage())
				.exception(exception.getMessage()).build();
		
		return HttpResponse.badRequest(responseMsg);

	}

}
