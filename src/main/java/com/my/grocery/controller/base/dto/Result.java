package com.my.grocery.controller.base.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result<T> {

    private T payload;
    private Error[] errors;

    public Result(T payload) {
        setPayload(payload);
    }

    public Result(T payload, Error[] errors) {
        setPayload(payload);
        setErrors(errors);
    }

    public Result(Error[] errors) {
        setErrors(errors);
    }

    public Result(Exception ex) {
        setErrors(Error.getListFromException(ex));
    }

    public static <T> Result<T> error(String error) {
        Result<T> retVal = new Result<>();
        retVal.setErrors(new Error[] { new Error(error) });
        return retVal;
    }

    public static <T> Result<T> error(Exception exception) {
        Result<T> retVal = new Result<>(exception);
        return retVal;
    }

    public static <T> Result<T> ok(T payload) {
        Result<T> retVal = new Result<>();
        retVal.setPayload(payload);
        return retVal;
    }

}