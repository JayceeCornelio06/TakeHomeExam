package com.example.Backend.TakeHomeExam.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;


@Data
@Document(collection = "products")
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id //dapat galing pala sa import org.springframework.data.annotation.Id;
    private String productId;
    //sa iba Long ang ginamit

    private String SKU;

    private String name;

    private String description;

    private BigDecimal cost;

    private String category;

    private BigDecimal sellingPrice;

    private List<String> tags;



}
