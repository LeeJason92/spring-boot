package com.fast_commerce.ecommerce.controller;

import com.fast_commerce.ecommerce.exception.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @GetMapping("/hello")
    public String Hello()
    {
        return "Hello";
    }

    @GetMapping("/bad-request")
    public ResponseEntity<String> BadRequestTest()
    {
        throw new BadRequestException("bad request exception triggered");
    }
}
