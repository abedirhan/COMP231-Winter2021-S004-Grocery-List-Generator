package com.my.grocery.controller.base.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Response<T> {

    private Status status;
    private T payload;
    private Error[] errors;
    private Object metadata;

    public static <T> Response<T> badRequest() {
        Response<T> response = new Response<>();
        response.setStatus(Status.BAD_REQUEST);
        return response;
    }

    public static <T> Response<T> badRequest(T payload) {
        Response<T> response = new Response<>();
        response.setStatus(Status.BAD_REQUEST);
        response.setPayload(payload);
        return response;
    }

    public static <T> Response<T> ok() {
        Response<T> response = new Response<>();
        response.setStatus(Status.OK);
        return response;
    }

    public static <T> Response<T> ok(T payload) {
        Response<T> response = new Response<>();
        response.setStatus(Status.OK);
        response.setPayload(payload);
        return response;
    }

    public static <T> Response<T> unauthorized() {
        Response<T> response = new Response<>();
        response.setStatus(Status.UNAUTHORIZED);
        return response;
    }

    public static <T> Response<T> validationException() {
        Response<T> response = new Response<>();
        response.setStatus(Status.VALIDATION_EXCEPTION);
        return response;
    }

    public static <T> Response<T> wrongCredentials() {
        Response<T> response = new Response<>();
        response.setStatus(Status.WRONG_CREDENTIALS);
        return response;
    }

    public static <T> Response<T> accessDenied() {
        Response<T> response = new Response<>();
        response.setStatus(Status.ACCESS_DENIED);
        return response;
    }

    public static <T> Response<T> exception() {
        Response<T> response = new Response<>();
        response.setStatus(Status.EXCEPTION);
        return response;
    }

    public static <T> Response<T> error(String messasge) {
        Response<T> response = new Response<>();
        response.setErrors(new Error[]{new Error(messasge)});
        response.setStatus(Status.EXCEPTION);
        return response;
    }

    public static <T> Response<T> exception(Exception ex) {
        Response<T> response = new Response<>();
        response.setStatus(Status.EXCEPTION);
        response.addErrorMsgToResponse(null, ex);
        return response;
    }

    public static <T> Response<T> exception(Exception ex, Object metadata) {
        Response<T> response = new Response<>();
        response.setStatus(Status.EXCEPTION);
        response.setMetadata(metadata);
        response.addErrorMsgToResponse(null, ex);
        return response;
    }

    public static <T> Response<T> exception(Exception ex, Object metadata, Status status) {
        Response<T> response = new Response<>();
        response.setStatus(status);
        response.setMetadata(metadata);
        response.addErrorMsgToResponse(null, ex);
        return response;
    }

    public static <T> Response<T> notFound() {
        Response<T> response = new Response<>();
        response.setStatus(Status.NOT_FOUND);
        return response;
    }

    public static <T> Response<T> duplicateEntity() {
        Response<T> response = new Response<>();
        response.setStatus(Status.DUPLICATE_ENTITY);
        return response;
    }

    public void addErrorMsgToResponse(String errorMsg, Exception ex) {
        setErrors(Error.getListFromException(ex, errorMsg));
    }

    public enum Status {
        OK, BAD_REQUEST, UNAUTHORIZED, VALIDATION_EXCEPTION, EXCEPTION, WRONG_CREDENTIALS, ACCESS_DENIED, NOT_FOUND, DUPLICATE_ENTITY
    }

    @Getter
    @Accessors(chain = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PageMetadata {
        private int size;
        private long totalElements;
        private int totalPages;
        private int number;

        public PageMetadata(int size, long totalElements, int totalPages, int number) {
            this.size = size;
            this.totalElements = totalElements;
            this.totalPages = totalPages;
            this.number = number;
        }
    }

}