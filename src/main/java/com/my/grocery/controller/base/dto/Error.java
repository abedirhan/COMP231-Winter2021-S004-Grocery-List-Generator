package com.my.grocery.controller.base.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.my.grocery.util.DateUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {

    private String name;
    private String errorMessage;
    private String status;
    private Date timestamp;

    public static Error namedError(String name, String errorMessage){
        Error error = new Error();
        error.setName(name);
        error.setErrorMessage(errorMessage);
        error.setTimestamp(DateUtils.today());
        return error;
    }

    public Error(String errorMessage) {
        setErrorMessage(errorMessage);
        setTimestamp(DateUtils.today());
    }

    public Error(String errorMessage, String status) {
        setErrorMessage(errorMessage);
        setStatus(status);
        setTimestamp(DateUtils.today());
    }

    public static Error[] getListFromException(Exception ex, String title){
        List<Error> retVal = new ArrayList<Error>();

        String titleString = (title != null ? title : "");

        if (titleString != ""){
            retVal.add(Error.namedError("Title", titleString));
        }

        String message = (ex.getMessage() != null ? ex.getMessage() : "");

        if (message != ""){
            retVal.add(Error.namedError("Message", message));
        }

        String details = (ex.toString() != null ? ex.toString() : "");

        if (details != ""){
            retVal.add(Error.namedError("Details", details));
        }

        Throwable cause = ex.getCause();
        if (cause != null){

            String causeString = (cause.toString() != null ? cause.toString() : "");

            if (causeString != ""){
                retVal.add(Error.namedError("Cause", causeString));
            }

        }

        StackTraceElement[] stackTraceElements = ex.getStackTrace();
        if (stackTraceElements != null){
            int index = 0;
            int totalToBeDisplayed = 3;
            for (StackTraceElement item : stackTraceElements){
                if (index >= totalToBeDisplayed){
                    break;
                }

                String stackString = (item.toString() != null ? item.toString() : "");

                if (stackString != "" && stackString.contains("com.alphaglobalit.apicore")){
                    retVal.add(Error.namedError("Stack (" + (index + 1) + "): ", stackString));
                    index++;
                }
            }
        }

        Error[] setErrors = new Error[retVal.size()];
        return retVal.toArray(setErrors);
    }

    public static Error[] getListFromException(Exception ex){
        return Error.getListFromException(ex, null);
    }

}