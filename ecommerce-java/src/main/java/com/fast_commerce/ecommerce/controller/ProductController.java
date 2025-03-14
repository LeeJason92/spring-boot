package com.fast_commerce.ecommerce.controller;

import com.fast_commerce.ecommerce.model.request.AddProductRequest;
import com.fast_commerce.ecommerce.model.request.GetProductRequest;
import com.fast_commerce.ecommerce.model.request.UpdateProductRequest;
import com.fast_commerce.ecommerce.model.response.AddProductResponse;
import com.fast_commerce.ecommerce.model.response.GetProductResponse;
import com.fast_commerce.ecommerce.model.response.UpdateProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController
{
    @GetMapping("")
    public ResponseEntity<List<GetProductResponse>> GetAllProducts()
    {
        return ResponseEntity.ok(List.of(GetProductResponse.builder()
                .ProductName("Test")
                .ProductPrice(11111)
                .ProductDesc("Test Desc")
                .build()));
    }

    @GetMapping("/get-product/{id}")
    public ResponseEntity<GetProductResponse> GetProductsById(@PathVariable String id)
    {
        return ResponseEntity.ok(GetProductResponse.builder()
                        .ProductId(Integer.valueOf(id))
                        .ProductName("Test")
                        .ProductPrice(11111)
                        .ProductDesc("Test Desc")
                .build());
    }

    @PostMapping("")
    public ResponseEntity<AddProductResponse> AddProduct(@RequestBody @Valid AddProductRequest request)
    {
        return ResponseEntity.ok(AddProductResponse.builder()
                .ProductId(Integer.valueOf(request.getProductId()))
                .ProductName(request.getProductName())
                .ProductPrice(request.getProductPrice())
                .ProductDesc(request.getProductDesc())
                .build());
    }

    @PutMapping("/update-product/{id}")
    public ResponseEntity<UpdateProductResponse> UpdateProduct(@PathVariable String id, @RequestBody @Valid UpdateProductRequest request)
    {
        return ResponseEntity.ok(UpdateProductResponse.builder()
                .ProductId(Integer.valueOf(request.getProductId()))
                .ProductName(request.getProductName())
                .ProductPrice(request.getProductPrice())
                .ProductDesc(request.getProductDesc())
                .build());
    }

    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<String> DeleteProduct(@PathVariable String id)
    {
        return ResponseEntity.ok(id + " is deleted");
    }


}
