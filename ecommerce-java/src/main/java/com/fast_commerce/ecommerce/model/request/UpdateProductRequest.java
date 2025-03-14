package com.fast_commerce.ecommerce.model.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest
{
    Integer ProductId;

    @NotBlank(message = "Product name required")
    @NotNull(message = "Product name required")
    @Size(min = 5, max = 2000, message = "Product name should between 5 and 2000 characters")
    String ProductName;

    @NotBlank(message = "Product price required")
    @NotNull(message = "Product price required")
    @Positive(message = "Product price can't be negative numbers")
    @Digits(integer = 10, fraction = 2, message = "Product price can't be more than 10 billion")
    Integer ProductPrice;

    @NotBlank(message = "Product description required")
    @NotNull(message = "Product description required")
    @Size(max = 2000, message = "Product description shouldn't more than 2000 characters")
    String ProductDesc;
}
