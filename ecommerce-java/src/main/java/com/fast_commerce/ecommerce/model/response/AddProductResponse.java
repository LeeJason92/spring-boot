package com.fast_commerce.ecommerce.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProductResponse
{
    Integer ProductId;
    String ProductName;
    Integer ProductPrice;
    String ProductDesc;
}
