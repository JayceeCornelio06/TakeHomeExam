package com.example.Backend.TakeHomeExam.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class SaveProductDTO {

    private String name;
    private String sku;
    private String description;
    private String category;
    private BigDecimal cost;
    private BigDecimal price;
    private List<String> tags;



}
