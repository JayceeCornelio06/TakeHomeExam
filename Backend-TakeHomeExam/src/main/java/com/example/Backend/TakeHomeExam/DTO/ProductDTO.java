package com.example.Backend.TakeHomeExam.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor

public class ProductDTO {

    private String productId;
    private String name;
    private String sku;
    private String description;
    private String categoryName;
    private BigDecimal cost;
    private BigDecimal price;
    private List<String> tags;

}
