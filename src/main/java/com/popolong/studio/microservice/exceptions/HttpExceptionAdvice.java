package com.popolong.studio.microservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@ResponseBody
public class HttpExceptionAdvice extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private HttpStatus httpStatus;
    private String descritpions;
    private Exception exceptionDetail;
    private HttpExceptionAdvice(HttpStatus status,String desc,Exception e) {
        this.httpStatus = status;
        this.descritpions=desc;
        this.exceptionDetail=e;
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpExceptionAdvice handleHttpMessageNotReadableException(Exception e) {
        return new HttpExceptionAdvice(HttpStatus.BAD_REQUEST,"Bad Request",e);
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public HttpExceptionAdvice handleHttpRequestMethodNotSupportedException(Exception e) {
        return new HttpExceptionAdvice(HttpStatus.METHOD_NOT_ALLOWED,"Method Not Allowed",e);
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public HttpExceptionAdvice handleHttpMediaTypeNotSupportedException(Exception e) {
        return new HttpExceptionAdvice(HttpStatus.UNSUPPORTED_MEDIA_TYPE,"Unsupported Media Type",e);
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HttpExceptionAdvice handleServerException(Exception e) {
        return new HttpExceptionAdvice(HttpStatus.INTERNAL_SERVER_ERROR,"Internal Server Error",e);
    }
}
