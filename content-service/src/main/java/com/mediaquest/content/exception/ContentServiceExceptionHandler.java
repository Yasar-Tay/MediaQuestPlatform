package com.mediaquest.content.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ContentServiceExceptionHandler {

  @GraphQlExceptionHandler
  public GraphQLError handleContentNotFoundException(ContentNotFoundException exception) {
    return GraphqlErrorBuilder.newError()
        .message(exception.getMessage())
        .errorType(ErrorType.NOT_FOUND)
        .build();
  }
}
