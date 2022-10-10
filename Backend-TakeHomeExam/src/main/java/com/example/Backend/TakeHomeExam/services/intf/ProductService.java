package com.example.Backend.TakeHomeExam.services.intf;

import com.example.Backend.TakeHomeExam.DTO.ProductNameListDTO;
import com.example.Backend.TakeHomeExam.DTO.SaveProductDTO;
import com.example.Backend.TakeHomeExam.models.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

   ProductEntity insertProduct(SaveProductDTO saveProductDTO);

   List<ProductEntity> getNameOfAllProductsBySorting(String field);

   List<ProductNameListDTO> getAllProducts();
}
