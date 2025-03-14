package com.fast_commerce.ecommerce.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse
{
    Integer ErrorCode;
    String ErrorMessage;
    LocalDateTime ErrorTimestamp;
}
