package com.fast_commerce.ecommerce.exception_handler;

import com.fast_commerce.ecommerce.exception.ResourcesNotFoundException;
import com.fast_commerce.ecommerce.model.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@ControllerAdvice
@Slf4j
public class GenericExceptionHandler
{
    public void WriteErrorLog(HttpStatus status, String errorMessage)
    {
        log.error("Error ({}) : {}", status, errorMessage);
    }

    @ExceptionHandler(ResourcesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse HandleResourcesNotFoundException(HttpServletRequest request,
                                                                        ResourcesNotFoundException exception)
    {
        WriteErrorLog(HttpStatus.NOT_FOUND , exception.getMessage());
        return ErrorResponse.builder()
                .ErrorCode(HttpStatus.NOT_FOUND.value())
                .ErrorMessage(exception.getMessage())
                .ErrorTimestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse HandleBadRequestException(HttpServletRequest request,
                                                                        com.fast_commerce.ecommerce.exception.BadRequestException exception)
    {
        WriteErrorLog(HttpStatus.BAD_REQUEST , exception.getMessage());
        return ErrorResponse.builder()
                .ErrorCode(HttpStatus.BAD_REQUEST.value())
                .ErrorMessage(exception.getMessage())
                .ErrorTimestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ErrorResponse HandleGenericException(HttpServletRequest request,
                                                                 Exception exception)
    {
        WriteErrorLog(HttpStatus.INTERNAL_SERVER_ERROR , exception.getMessage());
        return ErrorResponse.builder()
                .ErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .ErrorMessage(exception.getMessage())
                .ErrorTimestamp(LocalDateTime.now())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ErrorResponse HandleFieldNotValidException(MethodArgumentNotValidException exception)
    {
        WriteErrorLog(HttpStatus.INTERNAL_SERVER_ERROR , exception.getMessage());

        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(errItem ->
        {
            String errField = ((FieldError) errItem).getField();
            String errMessage = errItem.getDefaultMessage();

            errorMap.put(errField, errMessage);
        });

        String fullErrorMessage = "";

        for(Map.Entry<String, String> entry : errorMap.entrySet())
        {
            String key = entry.getKey();
            String value = entry.getValue();

            fullErrorMessage += key + ":" + value;
        }

        return ErrorResponse.builder()
                .ErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .ErrorMessage(fullErrorMessage)
                .ErrorTimestamp(LocalDateTime.now())
                .build();
    }

}
