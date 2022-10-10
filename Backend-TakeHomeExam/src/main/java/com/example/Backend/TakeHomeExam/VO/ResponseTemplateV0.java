package com.example.Backend.TakeHomeExam.VO;

import com.example.Backend.TakeHomeExam.models.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateV0 {

    private ProductEntity product;
    private Category category;

}
