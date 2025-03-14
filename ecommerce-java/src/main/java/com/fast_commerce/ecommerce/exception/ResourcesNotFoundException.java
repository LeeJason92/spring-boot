package com.fast_commerce.ecommerce.exception;

public class ResourcesNotFoundException extends RuntimeException
{
    public ResourcesNotFoundException(String errMessage)
    {
        super(errMessage);
    }
}
