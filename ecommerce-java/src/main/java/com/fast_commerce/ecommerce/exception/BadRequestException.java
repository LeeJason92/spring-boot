package com.fast_commerce.ecommerce.exception;

public class BadRequestException extends RuntimeException
{
    public BadRequestException(String errMessage)
    {
        super(errMessage);
    }
}
